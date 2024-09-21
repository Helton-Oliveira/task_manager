package com.example.taskMaster.application.usecase;

import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.domain.entities.abstractions.RebuildTask;
import com.example.taskMaster.application.domain.entities.abstractions.RebuildTaskImpl;
import com.example.taskMaster.application.usecase.abstractions.IGetToDoList;
import com.example.taskMaster.infra.repository.IRepository;

import java.util.List;

public class GetToDoList implements IGetToDoList {

    private final IRepository repository;

    public GetToDoList(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> execute() {
        RebuildTask rebuild = new RebuildTaskImpl();
        return repository.getAll(rebuild);
    }
}
