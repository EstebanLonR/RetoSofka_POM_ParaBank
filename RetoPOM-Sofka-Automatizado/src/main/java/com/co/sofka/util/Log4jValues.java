package com.co.sofka.util;

public enum Log4jValues {
    LOG4J_PROPERTIES_PATH("\\src\\main\\resources\\log4j\\log4j.properties");

    private final String value;

    Log4jValues(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

