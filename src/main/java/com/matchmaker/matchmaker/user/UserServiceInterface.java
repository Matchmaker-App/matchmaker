package com.matchmaker.matchmaker.user;

import java.util.List;

public interface UserServiceInterface {

    UserDTO getUserById(Long id);
    List<UserDTO> getAllUser();
    UserDTO createUser(UserRequestDTO user);
    UserDTO updateUserById(Long id, UserDTO updateInformation);
    void deleteUserById(Long id);
}
