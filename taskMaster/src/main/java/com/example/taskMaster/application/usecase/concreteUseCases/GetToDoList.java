package com.example.taskMaster.application.usecase.concreteUseCases;

import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.usecase.abstractionsUseCase.IGetToDoList;
import com.example.taskMaster.infra.repository.IRepository;

import java.util.List;

public class GetToDoList implements IGetToDoList {

    private final IRepository repository;

    public GetToDoList(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> execute() {
        return repository.getAll();
    }
}
