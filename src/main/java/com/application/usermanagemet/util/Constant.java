package com.application.usermanagemet.util;

public enum Constant {
    JWT_HEADER_KEY("Authorization"),
    TOKEN_TYPE("Bearer");

    private Constant(String enumValue) {
        value = enumValue;
    }

    private String value;

    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}