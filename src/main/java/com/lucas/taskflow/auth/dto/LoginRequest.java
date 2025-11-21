package com.lucas.taskflow.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String identifier; // puede ser username o email
    private String password;
}
