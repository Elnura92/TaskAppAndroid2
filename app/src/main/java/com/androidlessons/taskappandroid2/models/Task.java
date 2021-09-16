package com.androidlessons.taskappandroid2.models;

import java.io.Serializable;
import java.util.UUID;

public class Task implements Serializable {
    private String title;
    private String createdAt;
    private UUID id;

    public Task(String title, String createdAt) {
        this.title = title;
        this.createdAt = createdAt;
        this.id =  UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
