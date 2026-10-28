package com.chatapp.service;

import com.chatapp.entity.ChatMessage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChatServiceTest {

    private ChatService chatService = new ChatService();

    @Test
    public void testFormatMessage() {
        String formatted = chatService.formatMessage("Raviteja", "Hello World");
        assertNotNull(formatted);
        assertTrue(formatted.contains("Raviteja"));
        System.out.println("Format Message Test Passed: " + formatted);
    }

    @Test
    public void testChatMessageEntity() {
        ChatMessage msg = new ChatMessage("Alice", "Hi", "general");
        assertEquals("Alice", msg.getSender());
        assertEquals("general", msg.getRoom());
        assertNotNull(msg.getTimestamp());
        System.out.println("Chat Entity Test Passed: " + msg.getSender() + " -> " + msg.getContent());
    }
}