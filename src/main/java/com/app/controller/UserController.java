package com.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.AppUser;
import com.app.service.UserService;


@CrossOrigin(origins = "*")
@RestController
public class UserController {
	
	    @Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public ResponseEntity<String> registerUser(@RequestBody AppUser user) {
	        userService.registerUser(user);
	        return ResponseEntity.ok("User registered successfully!");
	    }
	    
	    @PostMapping("/login")
	    public Map<String, String> login(@RequestBody AppUser credentials) {
	        String username = credentials.getUserName();
	        String password = credentials.getPassword();
	        System.out.println("🔍 Checking username: " + username);
	        if (username == null || password == null) {
	            throw new RuntimeException("Username or password missing in request body");
	        }
	        return userService.loginUser(username, password);
	    }

	    

}
