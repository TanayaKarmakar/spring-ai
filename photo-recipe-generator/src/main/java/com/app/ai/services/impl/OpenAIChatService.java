package com.app.ai.services.impl;

import com.app.ai.services.ChatService;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class OpenAIChatService implements ChatService {
    private final ChatModel chatModel;

    public OpenAIChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public String getResponse(String prompt) {
        return chatModel.call(prompt);
    }
}
