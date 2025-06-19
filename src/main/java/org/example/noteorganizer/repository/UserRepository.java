package org.example.noteorganizer.repository;

import org.example.noteorganizer.entity.User;

public interface UserRepository {
    User findByUsername(String username);
    void save(User user);
}

