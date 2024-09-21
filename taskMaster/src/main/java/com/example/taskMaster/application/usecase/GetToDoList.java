package com.example.taskMaster.application.usecase;

import com.example.taskMaster.application.domain.builder.TaskBuilder;
import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.usecase.abstractions.IGetToDoList;
import com.example.taskMaster.infra.repository.IRepository;

import java.util.List;

public class GetToDoList implements IGetToDoList {

    private final IRepository repository;
    private final TaskBuilder builder;

    public GetToDoList(IRepository repository, TaskBuilder builder) {
        this.repository = repository;
        this.builder = builder;
    }

    @Override
    public List<Task> execute() {
        return repository.getAll(builder);
    }
}
