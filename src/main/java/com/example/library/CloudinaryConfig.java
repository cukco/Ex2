package com.example.library;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        Map<String,String> map = new HashMap<>();
        map.put("cloud_name","xfahvfjz");
        map.put("api_key","669153731473533");
        map.put("api_secret","37qXHEE97_qlU-77QQIdnDGNygI");
        return new Cloudinary(map);
    }
}
