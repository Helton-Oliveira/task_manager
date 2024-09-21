package com.example.taskMaster.application.domain.builder;

import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.domain.components.Priority;
import com.example.taskMaster.application.domain.components.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class TaskBuilderImpl implements TaskBuilder {

    private Task task = new Task();

    @Override
    public Task getTask() {
        var taskInstance = this.task;
        return taskInstance;
    }

    @Override
    public void setId(UUID id) {
        task.setId(id);
    }

    @Override
    public void setNameTask(String nameTask) {
        task.setNameTask(nameTask);
    }

    @Override
    public void setStatus(Status status) {
        task.setStatus(status);
    }

    @Override
    public void setDescription(String description) {
        task.setDescription(description);
    }

    @Override
    public void setPriority(Priority priority) {
        task.setPriority(priority);
    }

    @Override
    public void setDueDate(LocalDate dueDate) {
        task.setDueDate(dueDate);
    }

    @Override
    public void setCreatedAt(LocalDateTime createdAt) {
        task.setCreatedAt(createdAt);
    }
}
