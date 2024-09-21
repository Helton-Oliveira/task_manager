package com.example.taskMaster.application.domain.entities.abstractions;

import com.example.taskMaster.application.domain.components.Priority;
import com.example.taskMaster.application.domain.components.Status;
import com.example.taskMaster.application.domain.entities.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class RebuildTaskImpl implements RebuildTask {
    @Override
    public Task rebuild(UUID id, String nameTask, String description, Status status, Priority priority, LocalDate dueDate, LocalDateTime createdAt) {
        return Task.rebuild(id, nameTask, status, description, priority, dueDate, createdAt);
    }
}
