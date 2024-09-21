package com.example.taskMaster.application.usecase;

import com.example.taskMaster.application.usecase.abstractions.ICreateTask;
import com.example.taskMaster.infra.repository.IRepository;

public class CreateTask implements ICreateTask {

    private final IRepository repository;

    public CreateTask(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {

        repository.save();
    }
}
