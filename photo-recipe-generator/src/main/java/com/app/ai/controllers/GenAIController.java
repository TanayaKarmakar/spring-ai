package com.app.ai.controllers;

import com.app.ai.services.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GenAIController {
    private final ChatService chatService;

    public GenAIController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("askAI")
    public String getResponse(@RequestParam String prompt) {
        return chatService.getResponse(prompt);
    }
}
