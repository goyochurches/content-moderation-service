package com.user.flag.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.user.flag.service.UserFlagService;
import com.user.flag.utils.FileNotEmptyValidator;

@RestController
@RequestMapping("/api/user-flag")
public class UserFlagController {

    private final UserFlagService userFlagService;

    public UserFlagController(UserFlagService userFlagService) {
        this.userFlagService = userFlagService;
    }

    @PostMapping("/process")
    public ResponseEntity<?> processFile(@FileNotEmptyValidator @RequestParam("file") MultipartFile file) {

        try {
            ByteArrayOutputStream outputStream = userFlagService.handleFileProcessingInMemory(file);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"output.csv\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(outputStream.size())
                    .body(new InputStreamResource(
                            new ByteArrayInputStream(outputStream.toByteArray())));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing file: " + e.getMessage());
        }
    }
}