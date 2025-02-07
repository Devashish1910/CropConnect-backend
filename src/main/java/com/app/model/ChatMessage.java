package com.app.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "ChatMessage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {
    @Id
    private String id;
    private String senderId;
    private String receiverId;
    private String message;
    private Date timestamp;
    private boolean isEdited;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    private MessageType type;
}