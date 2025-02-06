package com.app.controller;

import com.app.model.ContactMessage;
import com.app.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*")
public class ContactMessageController {

    @Autowired
    private ContactMessageService service;

    @PostMapping
    public void submitMessage(@RequestBody ContactMessage message) {
        service.saveMessage(message);
    }

    @PutMapping("/{id}/close")
    public void closeMessage(@PathVariable String id) {
        service.closeMessage(id);
    }
}