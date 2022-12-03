package com.matchmaker.matchmaker.user;

import com.matchmaker.matchmaker.exception.ResourceNotFoundException;
import com.matchmaker.matchmaker.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email:" + email));

        return UserPrincipal.create(user);
    }

    @Override
    public UserDetails loadUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        return UserPrincipal.create(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return UserDTO.dateTransferUser(userRepository.findById(String.valueOf(id)).orElseThrow());
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::dateTransferUser)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserRequestDTO userCreate) {
        User user = User.builder()
                .name(userCreate.getName())
                .password(userCreate.getPassword())
                .email(userCreate.getEmail())
                .build();

        return UserDTO.dateTransferUser(userRepository.save(user));
    }

    @Override
    public UserDTO updateUserById(Long id, UserRequestDTO updateInformation) {
        Optional<User> searchedUserOptional = userRepository.findById(String.valueOf(id));
        if(searchedUserOptional.isPresent()){
            User user = searchedUserOptional.get();

            user.setName(updateInformation.getName());
            user.setEmail(updateInformation.getEmail());
            user.setPassword(updateInformation.getPassword());

            return UserDTO.dateTransferUser(userRepository.save(user));
        }
        throw new EntityNotFoundException("Didn't find user with id: " + id);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(String.valueOf(id));
    }
}
