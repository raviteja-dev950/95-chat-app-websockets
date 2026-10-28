package com.chatapp.service;

import com.chatapp.entity.ChatMessage;
import com.chatapp.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatMessageRepository repository;

    public ChatMessage saveMessage(String sender, String content, String room) {
        if (sender == null || sender.trim().isEmpty()) sender = "Anonymous";
        if (content == null || content.trim().isEmpty()) throw new IllegalArgumentException("Message cannot be empty");
        if (room == null || room.trim().isEmpty()) room = "general";
        ChatMessage msg = new ChatMessage(sender, content, room);
        msg.setTimestamp(LocalDateTime.now());
        return repository.save(msg);
    }

    public List<ChatMessage> getHistory(String room) {
        return repository.findByRoomOrderByTimestampAsc(room);
    }

    public String formatMessage(String sender, String content) {
        return "[" + LocalDateTime.now() + "] " + sender + ": " + content;
    }
}