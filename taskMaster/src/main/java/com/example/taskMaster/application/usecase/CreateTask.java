package com.example.taskMaster.application.usecase;

import com.example.taskMaster.application.strategy.ICreateByStrategy;
import com.example.taskMaster.application.usecase.abstractions.ICreateTask;
import com.example.taskMaster.application.usecase.creationValidations.ICreationValidation;
import com.example.taskMaster.infra.repository.IRepository;

import java.time.LocalDate;
import java.util.List;

public class CreateTask implements ICreateTask {

    private final IRepository repository;
    private final ICreateByStrategy createTaskByStrategy;
    private final List<ICreationValidation> validationList;

    public CreateTask(IRepository repository, ICreateByStrategy createTask, List<ICreationValidation> validationList) {
        this.repository = repository;
        this.createTaskByStrategy = createTask;
        this.validationList = validationList;
    }

    @Override
    public Boolean execute(Integer priority,String nameTask, String description, String dueDate) {
        var task = createTaskByStrategy.create(priority, nameTask, description, LocalDate.parse(dueDate));
        validationList.forEach(v -> v.validate(task));
        return repository.save(task);
    }
}
