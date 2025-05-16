package com.jwt_setup.controller;

import com.jwt_setup.model.AuthRequest;
import com.jwt_setup.service.UserService;
import com.jwt_setup.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid AuthRequest authRequest) {
        String response = userService.createUser(authRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // This endpoint is used to authenticate the user and generate a JWT token
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthRequest authRequest) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            return new ResponseEntity<>(jwtUtil.generateToken(authRequest.getUsername()), HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }
}
