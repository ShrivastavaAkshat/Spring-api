package com.rest.apis.controller;

import com.rest.apis.dto.User;
import com.rest.apis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * REST controller for handling user-related requests.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint to register a new user.
     *
     * @param user User details from request body.
     * @return ResponseEntity indicating the result of the registration.
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    /**
     * Endpoint to fetch user details.
     *
     * @param username Username query parameter.
     * @return ResponseEntity containing user details or error message.
     */
    @GetMapping("/fetch")
    public ResponseEntity<User> fetchUser(@RequestParam String username) {
        User user = userService.fetchUser(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

