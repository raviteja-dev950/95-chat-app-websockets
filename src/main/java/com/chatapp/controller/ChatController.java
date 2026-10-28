package com.chatapp.controller;

import com.chatapp.entity.ChatMessage;
import com.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> res = new HashMap<>();
        res.put("project", "95-chat-app-websockets");
        res.put("status", "Live - Chat App WebSockets");
        res.put("tier", "10 - System Design Level");
        res.put("owner", "Raviteja");
        res.put("websocket", "ws://localhost:8097/ws-chat");
        res.put("live", "https://nine5-chat-app-websockets.onrender.com");
        return res;
    }

    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> res = new HashMap<>();
        res.put("project", "95-chat-app-websockets");
        res.put("status", "UP");
        res.put("websocket", "Active - /ws-chat");
        return res;
    }

    @GetMapping("/api/history/{room}")
    public List<ChatMessage> history(@PathVariable String room) {
        return chatService.getHistory(room);
    }

    @PostMapping("/api/send")
    public ChatMessage send(@RequestBody ChatMessage msg) {
        return chatService.saveMessage(msg.getSender(), msg.getContent(), msg.getRoom());
    }
}