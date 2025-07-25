package com.app.ai.controllers;

import com.app.ai.services.ChatService;
import com.app.ai.services.ImageService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GenAIController {
    private final ChatService chatService;
    private final ImageService imageService;

    public GenAIController(ChatService chatService, ImageService imageService) {
        this.chatService = chatService;
        this.imageService = imageService;
    }

    @GetMapping("askAI")
    public String getResponse(@RequestParam String prompt) {
        return chatService.getResponse(prompt);
    }

    @GetMapping("askAIOptions")
    public String getResponseOptions(@RequestParam String prompt) {
        return chatService.getResponseOptions(prompt);
    }

    @GetMapping("generateImage")
    public void generateImage(HttpServletResponse response, @RequestParam String prompt) throws IOException {
        ImageResponse imageResponse = imageService.generateImage(prompt);
        String imageUrl = imageResponse.getResult().getOutput().getUrl();
        response.sendRedirect(imageUrl);
    }

    @GetMapping("generateImageOptions")
    public List<String> generateImageOptions(HttpServletResponse response, @RequestParam String prompt, @RequestParam int numImages) throws IOException {
        ImageResponse imageResponse = imageService.generateImagesWithOptions(prompt, numImages);
        return  imageResponse.getResults().stream()
                        .map(result -> result.getOutput().getUrl())
                                .toList();
    }
}
