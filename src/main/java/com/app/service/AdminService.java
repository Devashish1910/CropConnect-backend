package com.app.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.AppUser;
import com.app.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepo;
	
	public List<AppUser> getAllUsers()
	{
		return adminRepo.findAll();
	}
	
	
	public AppUser updateUser(String objectId, AppUser updatedUser) {
	    Optional<AppUser> existingUser = adminRepo.findById(objectId);
	    if (existingUser.isPresent()) {
	        AppUser user = existingUser.get();
	        user.setUserName(updatedUser.getUserName());
	        user.setEmail(updatedUser.getEmail());
	        return adminRepo.save(user);
	        
	    }
	    throw new RuntimeException("User not found");
	}
	
}
