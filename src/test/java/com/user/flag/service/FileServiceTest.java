package com.user.flag.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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
import com.user.flag.enums.LanguageType;

class FileServiceTest {

    @Mock
    private TranslationClient translationClient;

    @Mock
    private ScoringClient scoringClient;

    @InjectMocks
    private FileService fileService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testReadAndProcessInputFile() throws Exception {
        MultipartFile mockFile = mock(MultipartFile.class);
        when(mockFile.getInputStream()).thenReturn(getClass().getResourceAsStream("/test.csv"));

        when(translationClient.translateMessage(anyString(), eq(LanguageType.ENGLISH)))
                .thenReturn("translated message");
        when(scoringClient.getOffensivenessScore(anyString())).thenReturn(0.5f);

        Map<String, UserStats> userStatsMap = fileService.readAndProcessInputFile(mockFile);

        assertNotNull(userStatsMap);
        assertFalse(userStatsMap.isEmpty());
        assertTrue(userStatsMap.containsKey("user1"));
        assertEquals(1, userStatsMap.get("user1").getTotalMessages());
        assertEquals(0.5f, userStatsMap.get("user1").getAverageScore());
    }

    @Test
    void testGenerateNameFile() {
        String fileName = fileService.generateNameFile();
        assertNotNull(fileName);
        assertTrue(fileName.startsWith("output_"));
        assertTrue(fileName.endsWith(".csv"));
    }
}