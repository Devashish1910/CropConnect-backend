package com.app.controller;

import com.app.model.ChatMessage;
import com.app.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public ChatMessage sendMessage(@RequestBody ChatMessage message) {
        return chatService.saveMessage(message);
    }

    @GetMapping("/messages/{userId}")
    public List<ChatMessage> getMessages(@PathVariable String userId) {
        return chatService.getMessages(userId);
    }

    @DeleteMapping("/delete/{messageId}")
    public void deleteMessage(@PathVariable String messageId) {
        chatService.deleteMessage(messageId);
    }

    @PutMapping("/edit/{messageId}")
    public ChatMessage editMessage(@PathVariable String messageId, @RequestBody String newMessage) {
        return chatService.editMessage(messageId, newMessage);
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage broadcastMessage(ChatMessage chatMessage) {
        chatService.saveMessage(chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.newUser")
    @SendTo("/topic/public")
    public ChatMessage newUser(@RequestBody ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        chatService.saveMessage(chatMessage);
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSenderId());
        return chatMessage;
    }
}