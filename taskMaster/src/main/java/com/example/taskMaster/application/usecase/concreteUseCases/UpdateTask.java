package com.example.taskMaster.application.usecase.concreteUseCases;

import com.example.taskMaster.application.usecase.abstractionsUseCase.IUpdateTask;
import com.example.taskMaster.application.usecase.updateValidations.validationAbstractions.IUpdateValidation;
import com.example.taskMaster.infra.repository.IRepository;

import java.util.Map;
import java.util.UUID;

public class UpdateTask implements IUpdateTask {

    private final IRepository repository;
    private final IUpdateValidation validationList;

    public UpdateTask(IRepository repository, IUpdateValidation validationList) {
        this.repository = repository;
        this.validationList = validationList;
    }

    @Override
    public String execute(UUID id, Map<String, String> field) {

        validationList.validate(field, repository, id);
        var hasBeenUpdated = repository.update(id, field);
        if(!hasBeenUpdated) throw new RuntimeException("unable to update field");

        return "update completed successfully";
    }
}
