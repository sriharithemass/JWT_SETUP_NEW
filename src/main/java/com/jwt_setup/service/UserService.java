package com.jwt_setup.service;

import com.jwt_setup.model.AuthRequest;
import com.jwt_setup.model.Roles;
import com.jwt_setup.model.User;
import com.jwt_setup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String createUser(AuthRequest authRequest) {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        if (userRepository.existsByUsername(username)) {
            return "User already exists!";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Roles.ROLE_USER);

        userRepository.save(user);
        return "User registered successfully!";
    }
}
