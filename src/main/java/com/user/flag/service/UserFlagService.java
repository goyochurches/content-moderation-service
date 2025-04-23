package com.user.flag.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.user.flag.dto.UserStats;
import com.user.flag.utils.FileWriterUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserFlagService {

    @Autowired
    private FileService fileService;

    public ByteArrayOutputStream handleFileProcessingInMemory(MultipartFile file) throws IOException {
        Map<String, UserStats> userStatsMap = fileService.readAndProcessInputFile(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        FileWriterUtil.writeOutputToStream(outputStream, userStatsMap);
        return outputStream;
    }
}