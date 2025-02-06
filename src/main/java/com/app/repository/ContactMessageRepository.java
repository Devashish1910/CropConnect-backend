package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.model.ContactMessage;

public interface ContactMessageRepository extends MongoRepository<ContactMessage, String> {

}
