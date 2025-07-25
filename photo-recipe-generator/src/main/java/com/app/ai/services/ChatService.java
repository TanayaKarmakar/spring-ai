package com.app.ai.services;

import org.springframework.ai.chat.model.ChatResponse;

public interface ChatService {
    String getResponse(String prompt);
    String getResponseOptions(String prompt);
}
