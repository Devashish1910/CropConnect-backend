package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.AppUser;
import com.app.repository.UserRepository;

@Service
public class UserService {
	
		@Autowired
	    private UserRepository userRepository;

	    public AppUser registerUser(AppUser user) {
	        return userRepository.save(user);
	    }
}

