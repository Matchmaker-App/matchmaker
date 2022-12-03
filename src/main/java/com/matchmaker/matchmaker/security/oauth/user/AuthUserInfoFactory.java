package com.matchmaker.matchmaker.security.oauth.user;

import com.matchmaker.matchmaker.exception.OAuth2AuthenticationProcessingException;
import com.matchmaker.matchmaker.user.AuthProvider;

import java.util.Map;

public class AuthUserInfoFactory {

    public static AuthUserInfo get(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(AuthProvider.google.toString()))
            return new GoogleAuthUserInfo(attributes);
        else
            throw new OAuth2AuthenticationProcessingException(registrationId + " is not supported");
    }
}
