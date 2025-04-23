package com.user.flag.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import com.user.flag.dto.UserStats;

public class FileWriterUtil {

    public static void writeOutputFile(String outputFilePath, Map<String, UserStats> userStatsMap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write("user_id,total_messages,avg_score\n");

            for (Map.Entry<String, UserStats> entry : userStatsMap.entrySet()) {
                String userId = entry.getKey();
                UserStats stats = entry.getValue();
                String line = String.format(Locale.US, "%s,%d,%.2f\n", userId, stats.getTotalMessages(),
                        stats.getAverageScore());
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}