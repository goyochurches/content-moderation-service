package com.user.flag.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.user.flag.client.ScoringClient;
import com.user.flag.client.TranslationClient;
import com.user.flag.dto.UserStats;
import com.user.flag.enums.LanguageType;
import com.user.flag.utils.FileWriterUtil;
import com.user.flag.utils.UserStatsUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FileService {

    private final TranslationClient translationClient;
    private final ScoringClient scoringClient;

    public String generateNameFile() {
        return "output_" + LocalDate.now() + ".csv";
    }

    public Map<String, UserStats> readAndProcessInputFile(MultipartFile file) {
        Map<String, UserStats> userStatsMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                processUserMessageScore(userStatsMap, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userStatsMap;
    }

    private void processUserMessageScore(Map<String, UserStats> userStatsMap, String line) {
        String[] columns = line.split(",");
        String userId = columns[0];
        String message = columns[1];

        String translatedMessage = translationClient.translateMessage(message, LanguageType.ENGLISH);
        float score = scoringClient.getOffensivenessScore(translatedMessage);

        UserStatsUtil.addMessage(userStatsMap.computeIfAbsent(userId, k -> new UserStats()), score);
    }

    public void writeOutputFile(String outputFilePath, Map<String, UserStats> userStatsMap) {
        FileWriterUtil.writeOutputFile(outputFilePath, userStatsMap);
    }
}