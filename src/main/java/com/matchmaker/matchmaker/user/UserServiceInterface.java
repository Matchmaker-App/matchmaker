package com.matchmaker.matchmaker.user;

import java.util.List;

public interface UserServiceInterface {

    User getUserById(Long id);
    List<User> getAllUser();
    User createUser(User user);
    User updateUserById(Long id, User updateInformation);
    void deleteUserById(Long id);
}
