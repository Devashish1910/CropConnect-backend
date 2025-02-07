package com.app.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    private final CloudinaryProperties cloudinaryProperties;

    public CloudinaryConfig(CloudinaryProperties cloudinaryProperties) {
        this.cloudinaryProperties = cloudinaryProperties;
    }

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", cloudinaryProperties.getCloudName());
        config.put("api_key", cloudinaryProperties.getApiKey());
        config.put("api_secret", cloudinaryProperties.getApiSecret());
        return new Cloudinary(config);
    }
}


