package com.example.taskMaster.application.usecase.concreteUseCases;

import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.usecase.abstractionsUseCase.IGetTask;
import com.example.taskMaster.infra.repository.IRepository;

import java.util.UUID;

public class GetTask implements IGetTask {

    private final IRepository repository;

    public GetTask(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task execute(UUID id) {
        return repository.get(id);
    }
}
