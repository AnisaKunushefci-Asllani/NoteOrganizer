package org.example.noteorganizer.service;

import org.example.noteorganizer.entity.User;
import org.example.noteorganizer.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;
    private User loggedInUser;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            return true;
        }
        return false;
    }

    public void register(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        User user = new User(username, password);
        userRepository.save(user);
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
}
