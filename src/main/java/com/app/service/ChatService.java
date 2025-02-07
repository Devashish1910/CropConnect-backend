package com.app.service;

import com.app.model.ChatMessage;
import com.app.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public ChatMessage saveMessage(ChatMessage message) {
        return chatRepository.save(message);
    }

    public List<ChatMessage> getMessages(String userId) {
        return chatRepository.findBySenderIdOrReceiverId(userId, userId);
    }

    public void deleteMessage(String messageId) {
        chatRepository.deleteById(messageId);
    }

    public ChatMessage editMessage(String messageId, String newMessage) {
        ChatMessage message = chatRepository.findById(messageId).orElseThrow();
        message.setMessage(newMessage);
        message.setEdited(true);
        return chatRepository.save(message);
    }
}