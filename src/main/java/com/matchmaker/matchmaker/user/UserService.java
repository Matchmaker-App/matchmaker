package com.matchmaker.matchmaker.user;

import lombok.RequiredArgsConstructor;
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
    public UserDTO getUserById(Long id) {
        return UserDTO.dateTransferUser(userRepository.findById(id).orElseThrow());
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
                .username(userCreate.getUsername())
                .password(userCreate.getPassword())
                .email(userCreate.getEmail())
                .firstName(userCreate.getFirstName())
                .lastName(userCreate.getLastName())
                .birthDay(userCreate.getBirthDay())
                .build();

        return UserDTO.dateTransferUser(userRepository.save(user));
    }

    @Override
    public UserDTO updateUserById(Long id, UserDTO updateInformation) {
        Optional<User> searchedUserOptional = userRepository.findById(id);
        if(searchedUserOptional.isPresent()){
            User user = searchedUserOptional.get();

            user.setUsername(updateInformation.getUsername());
            user.setEmail(updateInformation.getEmail());
            user.setPassword(updateInformation.getPassword());

            return UserDTO.dateTransferUser(userRepository.save(user));
        }
        throw new EntityNotFoundException("Didn't find user with id: " + id);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
