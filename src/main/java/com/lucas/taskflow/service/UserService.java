package com.lucas.taskflow.service;

import com.lucas.taskflow.model.User;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean usernameExists(String username);

    boolean emailExists(String email);

    Optional<User> findByIdentifier(String identifier);
}
