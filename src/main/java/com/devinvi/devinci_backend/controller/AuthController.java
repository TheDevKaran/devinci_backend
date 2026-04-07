package com.devinvi.devinci_backend.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devinvi.devinci_backend.dto.AuthRequest;
import com.devinvi.devinci_backend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody AuthRequest req) {
        return Map.of("token", service.register(req.getEmail(), req.getPassword()));
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody AuthRequest req) {
        return Map.of("token", service.login(req.getEmail(), req.getPassword()));
    }
}
