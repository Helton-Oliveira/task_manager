package com.example.taskMaster.application.usecase;

import com.example.taskMaster.application.domain.builder.TaskBuilder;
import com.example.taskMaster.application.domain.director.DirectorBuilder;
import com.example.taskMaster.application.usecase.abstractions.ICreateTask;
import com.example.taskMaster.infra.repository.IRepository;

import java.time.LocalDate;

public class CreateTask implements ICreateTask {

    private final IRepository repository;
    private final TaskBuilder taskBuilder;

    public CreateTask(IRepository repository, TaskBuilder taskBuilder) {
        this.repository = repository;
        this.taskBuilder = taskBuilder;
    }

    @Override
    public Boolean execute() {
        var director = new DirectorBuilder(this.taskBuilder);
        director.createEasyLevelTask("commit in four days", "deve commitar em 4 dias", LocalDate.parse("2024-09-22"));
        var task = taskBuilder.getTask();
        System.out.println(task);

        return repository.save(task);
    }
}
