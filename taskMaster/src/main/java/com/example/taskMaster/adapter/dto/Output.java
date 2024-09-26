package com.example.taskMaster.adapter.dto;

import com.example.taskMaster.application.domain.components.Priority;
import com.example.taskMaster.application.domain.components.Status;
import com.example.taskMaster.application.domain.entities.Task;

import java.time.LocalDate;
import java.util.UUID;

public record Output(UUID id,
                     String name,
                     String description,
                     Status status,
                     Priority priority,
                     LocalDate dueDate
                     ) {
    public Output(Task task) {
        this(task.getId(), task.getNameTask(), task.getDescription(), task.getStatus(), task.getPriority(), task.getDueDate());
    }

}
