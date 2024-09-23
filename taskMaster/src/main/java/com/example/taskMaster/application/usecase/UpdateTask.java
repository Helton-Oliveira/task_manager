package com.example.taskMaster.application.usecase;

import com.example.taskMaster.application.usecase.abstractions.IUpdateTask;
import com.example.taskMaster.infra.repository.IRepository;

import java.util.Map;
import java.util.UUID;

public class UpdateTask implements IUpdateTask {

    private final IRepository repository;

    public UpdateTask(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public String execute(UUID id, Map<String, String> field) {
        var hasBeenUpdated = repository.update(id, field);
        System.out.println(hasBeenUpdated);
        if(!hasBeenUpdated) throw new RuntimeException("unable to update field");

        return "update completed successfully";
    }
}
