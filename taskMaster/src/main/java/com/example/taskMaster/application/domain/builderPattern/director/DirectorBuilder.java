package com.example.taskMaster.application.domain.builderPattern.director;

import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilder;
import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilderImpl;
import com.example.taskMaster.application.domain.components.Priority;
import com.example.taskMaster.application.domain.components.Status;
import com.example.taskMaster.application.domain.entities.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class DirectorBuilder {

    private final TaskBuilder builder;

    private DirectorBuilder(TaskBuilder builder) {
        this.builder = builder;
    }

    public static DirectorBuilder createDirector() {
        var builder = new TaskBuilderImpl();
        return new DirectorBuilder(builder);
    }

    public Task build() {
        return this.builder.getTask();
    }

    public void createEasyLevelTask(String nameTask, String description, LocalDate dueDate) {
        builder.setId(UUID.randomUUID());
        builder.setNameTask(nameTask);
        builder.setDescription(description);
        builder.setStatus(Status.TODO);
        builder.setPriority(Priority.LOW);
        builder.setDueDate(dueDate);
        builder.setCreatedAt(LocalDateTime.now());
    }

    public void createMediumLevelTask(String nameTask, String description, LocalDate dueDate) {
        builder.setId(UUID.randomUUID());
        builder.setNameTask(nameTask);
        builder.setDescription(description);
        builder.setStatus(Status.TODO);
        builder.setPriority(Priority.MEDIUM);
        builder.setDueDate(dueDate);
        builder.setCreatedAt(LocalDateTime.now());
    }

    public void createDifficultLevelTask(String nameTask, String description, LocalDate dueDate) {
        builder.setId(UUID.randomUUID());
        builder.setNameTask(nameTask);
        builder.setDescription(description);
        builder.setStatus(Status.TODO);
        builder.setPriority(Priority.HIGH);
        builder.setDueDate(dueDate);
        builder.setCreatedAt(LocalDateTime.now());
    }
}
