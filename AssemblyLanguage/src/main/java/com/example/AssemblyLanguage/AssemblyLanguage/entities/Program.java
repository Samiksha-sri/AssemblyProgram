package com.example.AssemblyLanguage.AssemblyLanguage.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String statements;
    @Enumerated(EnumType.STRING)
    private StatusCode statusCode;
    private int result;
    public void setStatements(String statements) {
        this.statements = statements;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
