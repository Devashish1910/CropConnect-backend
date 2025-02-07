package com.app.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.model.AppUser;
import com.app.repository.UserRepository;
import com.app.security.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public void registerUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public Map<String, String> loginUser(String username, String password) {
        Optional<AppUser> userOptional = userRepository.findByUserName(username);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Invalid username or password");
        }

        AppUser user = userOptional.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtUtil.generateToken(username, user.getRole());

        Map<String, String> response = new HashMap<>();
        response.put("role", user.getRole() != null ? user.getRole() : "UNKNOWN");
        response.put("customerId", user.getId() != null ? user.getId() : "0");
        response.put("token", token);

        return response;
    }

    public Optional<AppUser> findByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}