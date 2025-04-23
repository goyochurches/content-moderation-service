package com.user.flag.client;

public enum LanguageType {
    ENGLISH("en"),
    SPANISH("es"),
    FRENCH("fr"),
    GERMAN("de"),
    CHINESE("zh"),
    JAPANESE("ja");

    private final String code;

    LanguageType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}