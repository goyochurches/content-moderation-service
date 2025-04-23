package com.user.flag.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserFlagService userFlagService;

    @PostMapping("/process")
    public ResponseEntity<String> processFile(@FileNotEmptyValidator @RequestParam("file") MultipartFile file) {
        try {
            String outputFilePath = userFlagService.handleFileProcessing(file);
            return ResponseEntity.ok("File processed successfully. Output saved at: " + outputFilePath);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing file: " + e.getMessage());
        }
    }
}