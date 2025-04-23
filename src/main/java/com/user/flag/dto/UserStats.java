package com.user.flag.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserStats {
    private int totalMessages;
    private float totalScore;

    public float getAverageScore() {
        return totalMessages == 0 ? 0 : totalScore / totalMessages;
    }
}