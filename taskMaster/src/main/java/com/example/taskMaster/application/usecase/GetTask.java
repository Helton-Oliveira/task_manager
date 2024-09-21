package com.example.taskMaster.application.usecase;

import com.example.taskMaster.application.domain.Task;
import com.example.taskMaster.application.usecase.abstractions.IGetTask;
import com.example.taskMaster.infra.repository.IRepository;

public class GetTask implements IGetTask {

    private final IRepository repository;

    public GetTask(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task execute() {
        return null;
    }
}
