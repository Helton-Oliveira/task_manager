package com.example.taskMaster.application.domain.entities;

import com.example.taskMaster.application.domain.components.Priority;
import com.example.taskMaster.application.domain.components.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Task {
    private UUID id; //
    private String nameTask;
    private Status status; //
    private String description;
    private Priority priority; //
    private LocalDate dueDate;
    private LocalDateTime createdAt; //

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task {" +
                "id: " + id +
                ", nameTask: " + nameTask + '\'' +
                ", status: " + status +
                ", description: " + description + '\'' +
                ", priority: " + priority +
                ", dueDate: " + dueDate +
                ", createdAt: " + createdAt +
                '}';
    }
}
