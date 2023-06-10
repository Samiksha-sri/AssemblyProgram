package com.example.AssemblyLanguage.AssemblyLanguage.dtos;

import com.example.AssemblyLanguage.AssemblyLanguage.entities.Program;
import com.example.AssemblyLanguage.AssemblyLanguage.entities.StatusCode;
import jdk.jshell.Snippet;

public class ResponseDTO {

    private int result;
    private StatusCode statusCode;
    private String message;


    public void setResult(int result) {
        this.result = result;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
