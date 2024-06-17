package com.rest.apis.storage;

import com.rest.apis.dto.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * In-memory storage for user data.
 */
@Component
public class UserStorage {
    private final Map<String, User> userStorage = new HashMap<>();

    public boolean existsByUsername(String username) {
        return userStorage.containsKey(username);
    }

    public void save(User user) {
        userStorage.put(user.getUsername(), user);
    }

    public User findByUsername(String username) {
        return userStorage.get(username);
    }
}
