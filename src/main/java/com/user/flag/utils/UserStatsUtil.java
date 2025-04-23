package com.user.flag.utils;

import com.user.flag.dto.UserStats;

public class UserStatsUtil {

    public static void addMessage(UserStats userStats, float score) {
        userStats.setTotalMessages(userStats.getTotalMessages() + 1);
        userStats.setTotalScore(userStats.getTotalScore() + score);
    }

    public static float calculateAverageScore(UserStats userStats) {
        return userStats.getTotalMessages() == 0 ? 0 : userStats.getTotalScore() / userStats.getTotalMessages();
    }
}