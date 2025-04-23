package com.user.flag.enums;

public enum LanguageType {
    ENGLISH("en");

    private final String code;

    LanguageType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}