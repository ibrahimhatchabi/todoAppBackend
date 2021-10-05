package com.example.todoappbackend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String dueTime;
    private boolean isDone;
    private Category category;

    public Task(String title, String dueTime, boolean isDone, Category category) {
        this.title = title;
        this.dueTime = dueTime;
        this.isDone = isDone;
        this.category = category;
    }

    public Task(Long id) {
        this.id = id;
    }

    public Task() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
