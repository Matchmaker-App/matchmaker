package com.matchmaker.matchmaker.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserServiceInterface {
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
    UserDetails loadUserById(String id);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUser();
    UserDTO createUser(UserRequestDTO user);
    UserDTO updateUserById(Long id, UserRequestDTO updateInformation);
    void deleteUserById(Long id);
}
