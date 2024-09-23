package com.example.taskMaster.application.usecase.abstractions;

import com.example.taskMaster.application.domain.entities.Task;

import java.util.UUID;

public interface IGetTask {
    Task execute(UUID id);
}
