package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	
	

}
