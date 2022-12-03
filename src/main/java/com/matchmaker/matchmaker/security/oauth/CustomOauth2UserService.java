package com.matchmaker.matchmaker.security.oauth;

import com.matchmaker.matchmaker.exception.OAuth2AuthenticationProcessingException;
import com.matchmaker.matchmaker.security.UserPrincipal;
import com.matchmaker.matchmaker.security.oauth.user.AuthUserInfo;
import com.matchmaker.matchmaker.security.oauth.user.AuthUserInfoFactory;
import com.matchmaker.matchmaker.user.AuthProvider;
import com.matchmaker.matchmaker.user.User;
import com.matchmaker.matchmaker.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;


@Service
@AllArgsConstructor
public class CustomOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        try {
            return processOAuth2User(userRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception e) {
            throw new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        AuthUserInfo authUserInfo = AuthUserInfoFactory.get(userRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());

        if (StringUtils.isEmpty(authUserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from provider");
        }

        Optional<User> userOptional = userRepository.findByEmail(authUserInfo.getEmail());
        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            user = update(user, authUserInfo);
        } else {
            user = register(userRequest, authUserInfo);
        }
        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }

    private User register(OAuth2UserRequest userRequest, AuthUserInfo authUserInfo) {
        User user = new User();
        user.setProvider(AuthProvider.valueOf(userRequest.getClientRegistration().getRegistrationId()));
        user.setProviderId(authUserInfo.getId());
        user.setName(authUserInfo.getName());
        user.setEmail(authUserInfo.getEmail());
        user.setImageUrl(authUserInfo.getImageUrl());

        return userRepository.save(user);
    }

    private User update(User user, AuthUserInfo authUserInfo) {
        user.setName(authUserInfo.getName());
        user.setImageUrl(authUserInfo.getImageUrl());
        return userRepository.save(user);
    }
}
