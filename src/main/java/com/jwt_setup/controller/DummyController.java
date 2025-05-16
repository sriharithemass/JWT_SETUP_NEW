package com.jwt_setup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    @GetMapping
    public String dummy() {
        return "Hello, this is a dummy endpoint!";
    }
}
