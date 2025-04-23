package com.user.flag.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.multipart.MultipartFile;

import com.user.flag.client.ScoringClient;
import com.user.flag.client.TranslationClient;
import com.user.flag.dto.UserStats;

class UserFlagServiceTest {

    @Mock
    private TranslationClient translationClient;

    @Mock
    private ScoringClient scoringClient;

    @Mock
    private FileService fileService;

    @InjectMocks
    private UserFlagService userFlagService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHandleFileProcessing() throws Exception {
        MultipartFile mockFile = mock(MultipartFile.class);
        when(mockFile.getInputStream()).thenReturn(getClass().getResourceAsStream("/test.csv"));
        when(mockFile.getOriginalFilename()).thenReturn("test.csv");
        when(mockFile.getSize()).thenReturn(1024L);
        when(mockFile.getContentType()).thenReturn("text/csv");

        ByteArrayOutputStream response = userFlagService.handleFileProcessingInMemory(mockFile);

        assertNotNull(response);
        assertTrue(response.toString().contains("user_id,total_messages,avg_score"));
    }

    @Test
    void testHandleFileProcessingInMemory() throws Exception {
        MultipartFile mockFile = mock(MultipartFile.class);
        when(mockFile.getInputStream()).thenReturn(getClass().getResourceAsStream("/test.csv"));
        when(mockFile.getOriginalFilename()).thenReturn("test.csv");
        when(mockFile.getSize()).thenReturn(1024L);
        when(mockFile.getContentType()).thenReturn("text/csv");

        ByteArrayOutputStream response = userFlagService.handleFileProcessingInMemory(mockFile);

        assertNotNull(response);
        assertTrue(response.toString().contains("user_id,total_messages,avg_score"));
    }

    @Test
    void testProcessInputFile() throws Exception {
        MultipartFile mockFile = mock(MultipartFile.class);
        when(mockFile.getInputStream()).thenReturn(getClass().getResourceAsStream("/test.csv"));
        when(mockFile.getOriginalFilename()).thenReturn("test.csv");
        when(mockFile.getSize()).thenReturn(1024L);
        when(mockFile.getContentType()).thenReturn("text/csv");

        Map<String, UserStats> userStatsMap = fileService.readAndProcessInputFile(mockFile);

        assertNotNull(userStatsMap);
    }
}