package com.app.ai.services;

import org.springframework.ai.image.ImageResponse;

public interface ImageService {
    ImageResponse generateImage(String prompt, String quality, int n, int width, int height);

    ImageResponse generateImagesWithOptions(String prompt, int numImages);
}
