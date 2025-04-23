package com.user.flag.client;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.user.flag.enums.LanguageType;

@Component
public class TranslationClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${translation.service.url}")
    private String translationServiceUrl;

    private final Cache<String, String> translationCache = Caffeine.newBuilder()
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .maximumSize(1000)
            .build();

    public String translateMessage(String message, LanguageType languageType) {
        String cacheKey = message + "|" + languageType.getCode();
        return translationCache.get(cacheKey, key -> createTranslation(message, languageType));
    }

    private String createTranslation(String message, LanguageType languageType) {
        try {
            String urlWithLanguage = translationServiceUrl + "?lang=" + languageType.getCode();
            return restTemplate.postForObject(urlWithLanguage, message, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return message;
        }
    }
}