package com.lucas.taskflow.service;

import com.lucas.taskflow.model.User;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> findByUsername(String username);

    boolean usernameExists(String username);
}
