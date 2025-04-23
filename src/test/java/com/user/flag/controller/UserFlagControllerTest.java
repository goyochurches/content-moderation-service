package com.user.flag.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import com.user.flag.service.UserFlagService;

@WebMvcTest(controllers = UserFlagController.class)
class UserFlagControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserFlagService userFlagService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessFile() throws Exception {
        ByteArrayOutputStream mockOutputStream = new ByteArrayOutputStream();
        mockOutputStream.write("user_id,total_messages,avg_score\nuser1,5,0.75\n".getBytes());

        when(userFlagService.handleFileProcessingInMemory(any(MultipartFile.class)))
                .thenReturn(mockOutputStream);

        mockMvc.perform(multipart("/api/user-flag/process")
                .file("file", "test content".getBytes()))
                .andExpect(status().isOk())
                .andReturn();

        verify(userFlagService, times(1)).handleFileProcessingInMemory(any(MultipartFile.class));
    }

    @Test
    void testHandleFileProcessingWithEmptyFile() throws Exception {
        MockMultipartFile emptyFile = new MockMultipartFile("file", "", "text/plain", new byte[0]);

        mockMvc.perform(multipart("/api/user-flag/process")
                .file(emptyFile))
                .andExpect(status().isBadRequest())
                .andReturn();

        verify(userFlagService, times(0)).handleFileProcessingInMemory(any(MultipartFile.class));
    }
}