package com.example.taskMaster.application.domain.builderPattern.builder;

import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.domain.components.Priority;
import com.example.taskMaster.application.domain.components.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public interface TaskBuilder {
    Task getTask();
    void setId(UUID id);
    void setNameTask(String nameTask);
    void setStatus(Status status);
    void setDescription(String description);
    void setPriority(Priority priority);
    void setDueDate(LocalDate dueDate);
    void setCreatedAt(LocalDateTime createdAt);
}
