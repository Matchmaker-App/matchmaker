package com.matchmaker.matchmaker.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUserById(Long id, User updateInformation) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
