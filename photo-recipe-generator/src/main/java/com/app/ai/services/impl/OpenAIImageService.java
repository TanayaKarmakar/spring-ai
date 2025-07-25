package com.app.ai.services.impl;

import com.app.ai.services.ImageService;
import org.springframework.ai.image.ImageOptions;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class OpenAIImageService implements ImageService  {
    private final OpenAiImageModel openAiImageModel;

    public OpenAIImageService(OpenAiImageModel openAiImageModel) {
        this.openAiImageModel = openAiImageModel;
    }

    @Override
    public ImageResponse generateImage(String prompt) {
        return openAiImageModel.call(
                new ImagePrompt(prompt)
        );
    }

    @Override
    public ImageResponse generateImagesWithOptions(String prompt, int numImages) {
        ImageOptions options = OpenAiImageOptions.builder()
                .quality("hd")
                .N(numImages)
                .model("dall-e-3")
                .style("vivid")
                .height(1024)
                .width(1024).build();
        return openAiImageModel.call(
          new ImagePrompt(prompt, options)
        );
    }
}
