package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Blog;
import com.app.repository.BlogRepository;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
	public Blog addBlog(Blog blog)
	{
		return blogRepository.save(blog);
		
	}
	

}
