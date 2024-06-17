package com.rest.apis.service;

import com.rest.apis.exception.UserNotFoundException;
import com.rest.apis.dto.User;
import com.rest.apis.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service layer for user-related operations.
 */
@Service
public class UserService {
    private final UserStorage userStorage;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserStorage userStorage, PasswordEncoder passwordEncoder) {
        this.userStorage = userStorage;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        if (userStorage.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already exists");
        }
        // Securely store password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userStorage.save(user);
    }

    public User fetchUser(String username) {
        User user = userStorage.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }
}
