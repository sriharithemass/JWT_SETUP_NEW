package com.jwt_setup.model;

import jakarta.validation.constraints.Size;

public class AuthRequest {

    @Size(min = 3, max = 100, message = "Username must be between 3 and 100 characters")
    private String username;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthRequest() {
    }
}
