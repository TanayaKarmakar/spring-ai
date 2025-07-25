package com.app.ai.services.impl;

import com.app.ai.services.ChatService;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
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

    @Override
    public String getResponseOptions(String prompt) {
        ChatResponse response = chatModel.call(new Prompt(
                prompt,
                OpenAiChatOptions.builder()
                        .model("gpt-4o")
                        .temperature(0.4)
                        .build()
        ));

        return response.getResult().getOutput().getText();
    }
}
