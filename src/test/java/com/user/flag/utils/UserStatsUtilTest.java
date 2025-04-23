package com.user.flag.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.user.flag.dto.UserStats;

class UserStatsUtilTest {

    @Test
    void testAddMessage() {
        UserStats stats = new UserStats();
        UserStatsUtil.addMessage(stats, 2.5f);

        assertEquals(1, stats.getTotalMessages());
        assertEquals(2.5f, stats.getTotalScore());
    }

    @Test
    void testCalculateAverageScore() {
        UserStats stats = new UserStats();
        stats.setTotalMessages(4);
        stats.setTotalScore(8.0f);

        float average = UserStatsUtil.calculateAverageScore(stats);
        assertEquals(2.0f, average);
    }
}