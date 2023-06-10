package com.example.AssemblyLanguage.AssemblyLanguage.entities;

public enum StatusCode {

    SUCCESS("SUCCESS"),
    FAILURE("FAILURE");

    private final String value;

    StatusCode(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
