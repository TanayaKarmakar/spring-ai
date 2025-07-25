package com.app.ai.services;

import org.springframework.ai.image.ImageResponse;

public interface ImageService {
    ImageResponse generateImage(String prompt);

    ImageResponse generateImagesWithOptions(String prompt, int numImages);
}
