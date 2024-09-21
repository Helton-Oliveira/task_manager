package com.example.taskMaster.application.domain.director;

import com.example.taskMaster.application.domain.builder.TaskBuilder;
import com.example.taskMaster.application.domain.components.Priority;
import com.example.taskMaster.application.domain.components.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class DirectorBuilder implements IDirectorBuilder{

    private final TaskBuilder builder;

    public DirectorBuilder(TaskBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void createEasyLevelTask(String nameTask, String description, LocalDate dueDate) {
        builder.setId(UUID.randomUUID());
        builder.setNameTask(nameTask);
        builder.setDescription(description);
        builder.setStatus(Status.TODO);
        builder.setPriority(Priority.LOW);
        builder.setDueDate(dueDate);
        builder.setCreatedAt(LocalDateTime.now());
    }

    @Override
    public void createMediumLevelTask(String nameTask, String description, LocalDate dueDate) {
        builder.setId(UUID.randomUUID());
        builder.setNameTask(nameTask);
        builder.setDescription(description);
        builder.setStatus(Status.TODO);
        builder.setPriority(Priority.MEDIUM);
        builder.setDueDate(dueDate);
        builder.setCreatedAt(LocalDateTime.now());
    }

    @Override
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
