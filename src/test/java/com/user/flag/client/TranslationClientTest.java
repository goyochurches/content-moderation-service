package com.user.flag.client;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.user.flag.enums.LanguageType;

class TranslationClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private TranslationClient translationClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testTranslateMessage() {
        String message = "Hello";
        String translatedMessage = "Hello";

        when(restTemplate.postForObject(anyString(), eq(message), eq(String.class))).thenReturn(translatedMessage);

        String result = translationClient.translateMessage(message, LanguageType.ENGLISH);

        assertEquals(translatedMessage, result);
        verify(restTemplate, times(1)).postForObject(anyString(), eq(message), eq(String.class));
    }
}