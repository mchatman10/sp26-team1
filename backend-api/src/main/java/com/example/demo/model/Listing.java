package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    private String description;

    public Long getSessionId() { return sessionId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}