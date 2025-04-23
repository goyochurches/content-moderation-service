package com.user.flag.client;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

@Component
public class ScoringClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${scoring.service.url}")
    private String scoringServiceUrl;

    private final Cache<String, Float> scoringCache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(1000)
            .build();

    public float getOffensivenessScore(String message) {
        return scoringCache.get(message, this::createScore);
    }

    private float createScore(String message) {
        try {
            Float score = restTemplate.postForObject(scoringServiceUrl, message, Float.class);
            return score != null ? score : 0.0f;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }
}