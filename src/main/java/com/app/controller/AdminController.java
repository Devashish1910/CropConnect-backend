package com.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.AppUser;
import com.app.model.Blog;
import com.app.service.AdminService;
import com.app.service.BlogService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private BlogService blogService;
	
	List<AppUser> al=new ArrayList<AppUser>();
	
	@GetMapping("/users")
	public List<AppUser> getAllUsers()
	{
		return adminService.getAllUsers();
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<AppUser> updateUser(@PathVariable("id") String id, @RequestBody AppUser updatedUser) {
//	    ObjectId objectId = new ObjectId(id);
	    
	    AppUser user = adminService.updateUser(id, updatedUser);
	    
	    return ResponseEntity.ok(user);
	}
	
	 @PostMapping("/blog")
	    public ResponseEntity<String> addBlog(
	            @RequestParam("title") String title,
	            @RequestParam("content") String content,
	            @RequestParam("category") String category,
	            @RequestParam(value = "published", defaultValue = "false") boolean published,
	            @RequestPart("image") MultipartFile image) {
		 
	        try {
	            // Define storage path
	            String uploadDir = "uploads/";
	            File uploadPath = new File(uploadDir);
	            if (!uploadPath.exists()) {
	                uploadPath.mkdirs();
	            }

	            // Save the image
	            String imagePath = uploadDir + image.getOriginalFilename();
	            File file = new File(imagePath);
	            image.transferTo(file);

	            // Call service layer (You can update your Blog entity and save the image path in DB)
	            Blog blog = new Blog();
	            blog.setTitle(title);
	            blog.setContent(content);
	            blog.setCategory(category);
	            blog.setPublished(published);
	            blog.setImageUrl(imagePath); // Save image path

	            blogService.addBlog(blog); // Save to DB

	            return ResponseEntity.ok("Blog added successfully!");

	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Error uploading image: " + e.getMessage());
	        }
	    }
	
	
	
}
