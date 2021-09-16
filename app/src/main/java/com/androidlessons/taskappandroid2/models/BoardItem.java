package com.androidlessons.taskappandroid2.models;

import android.widget.TextView;

public class BoardItem {
    private int imageView;
    private String title;
    private String description;

    public BoardItem(int imageView, String title, String description) {
        this.imageView = imageView;
        this.title = title;
        this.description = description;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
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
}
