package com.lucas.taskflow.auth.controller;

import com.lucas.taskflow.auth.AuthService;
import com.lucas.taskflow.auth.dto.AuthResponse;
import com.lucas.taskflow.auth.dto.LoginRequest;
import com.lucas.taskflow.auth.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
