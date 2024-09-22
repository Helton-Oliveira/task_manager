package com.example.taskMaster.application.usecase;

import com.example.taskMaster.application.strategy.ICreateByStrategy;
import com.example.taskMaster.application.usecase.abstractions.ICreateTask;
import com.example.taskMaster.infra.repository.IRepository;

import java.time.LocalDate;

public class CreateTask implements ICreateTask {

    private final IRepository repository;
    private final ICreateByStrategy createTaskByStrategy;

    public CreateTask(IRepository repository, ICreateByStrategy createTask) {
        this.repository = repository;
        this.createTaskByStrategy = createTask;
    }

    @Override
    public Boolean execute(Integer priority,String nameTask, String description, String dueDate) {
        var task = createTaskByStrategy.create(priority, nameTask, description, LocalDate.parse(dueDate));
        return repository.save(task);
    }
}
