package com.app.service;

import com.app.model.ContactMessage;
import com.app.model.MessageStatus;
import com.app.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${admin.email}")
    private String adminEmail;

    public void saveMessage(ContactMessage message) {
        message.setStatus(MessageStatus.OPEN);
        repository.save(message);
        sendEmailToAdmin(message);
    }

    private void sendEmailToAdmin(ContactMessage message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(adminEmail);
        mailMessage.setSubject("New Contact Message from " + message.getName());
        mailMessage.setText("Message: " + message.getMessage() + "\nFrom: " + message.getEmail());
        mailSender.send(mailMessage);
    }

    public void closeMessage(String id) {
        ContactMessage message = repository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
        message.setStatus(MessageStatus.CLOSED);
        repository.save(message);
    }
}