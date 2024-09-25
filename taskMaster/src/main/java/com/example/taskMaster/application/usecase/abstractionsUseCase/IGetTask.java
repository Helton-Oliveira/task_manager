package com.example.taskMaster.application.usecase.abstractionsUseCase;

import com.example.taskMaster.application.domain.entities.Task;

import java.util.UUID;

public interface IGetTask {
    Task execute(UUID id);
}
