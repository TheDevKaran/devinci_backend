package com.devinvi.devinci_backend.service;

import org.springframework.stereotype.Service;

import com.devinvi.devinci_backend.entity.User;
import com.devinvi.devinci_backend.repository.UserRepository;
import com.devinvi.devinci_backend.util.JwtUtil;
import com.devinvi.devinci_backend.util.Password;

@Service
public class AuthService {

    private final UserRepository repo;
    private final Password passwordUtil;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository repo, Password passwordUtil, JwtUtil jwtUtil) {
        this.repo = repo;
        this.passwordUtil = passwordUtil;
        this.jwtUtil = jwtUtil;
    }

    public String register(String email, String password) {
        if (repo.findByEmail(email).isPresent()) {
            throw new RuntimeException("Email exists");
        }

        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(passwordUtil.hash(password));

        // 🔹 DEFAULT ROLE FOR NEW USERS
        user.setRole("user");

        repo.save(user);

        // 🔹 TOKEN WITH ROLE
        return jwtUtil.generateToken(
            user.getEmail(),
            user.getRole()
        );
    }

    public String login(String email, String password) {
        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!user.getPasswordHash().equals(passwordUtil.hash(password))) {
            throw new RuntimeException("Invalid credentials");
        }

        // 🔹 TOKEN WITH ROLE
        return jwtUtil.generateToken(
            user.getEmail(),
            user.getRole()
        );
    }
}
