package com.user.flag.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.user.flag.dto.UserStats;

class FileWriterUtilTest {

    @Test
    void testWriteOutputFile() throws IOException {
        Map<String, UserStats> userStatsMap = new HashMap<>();
        UserStats stats = new UserStats();
        stats.setTotalMessages(5);
        stats.setTotalScore(3.5f);
        userStatsMap.put("user1", stats);

        File resourceFile = new File(getClass().getClassLoader().getResource("test.csv").getFile());

        FileWriterUtil.writeOutputFile(resourceFile.getAbsolutePath(), userStatsMap);

        String content = Files.readString(resourceFile.toPath());

        String expectedLine = "user1,5,0.70";
        assertTrue(content.contains(expectedLine), "Expected line not found in file: " + expectedLine);
    }
}