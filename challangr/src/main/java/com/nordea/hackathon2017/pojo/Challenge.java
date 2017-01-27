package com.nordea.hackathon2017.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nordea.hackathon2017.pojo.Json;

public class Challenge extends Json {

    private int id;

    private String title;

    private String description;

    private String sample;

    private int difficultyId;

    public Challenge() {
    }

    public Challenge(String title, String description, String sample, int difficultyId) {
        this.title = title;
        this.description = description;
        this.sample = sample;
        this.difficultyId = difficultyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public int getDifficultyId() {
        return difficultyId;
    }

    public void setDifficultyId(int difficultyId) {
        this.difficultyId = difficultyId;
    }

    @Override
    public String toString() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}