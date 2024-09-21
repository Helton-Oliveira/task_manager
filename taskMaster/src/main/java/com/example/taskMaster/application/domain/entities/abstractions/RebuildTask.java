package com.example.taskMaster.application.domain.entities.abstractions;

import com.example.taskMaster.application.domain.components.Priority;
import com.example.taskMaster.application.domain.components.Status;
import com.example.taskMaster.application.domain.entities.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public interface RebuildTask {
    Task rebuild(UUID id, String nametask, String description, Status status, Priority priority, LocalDate duedate, LocalDateTime createdat);
}
