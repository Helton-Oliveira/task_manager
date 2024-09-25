package com.example.taskMaster.application.usecase.updateValidations.concreteValidations;

import com.example.taskMaster.application.domain.components.Status;
import com.example.taskMaster.application.usecase.updateValidations.validationAbstractions.ICheckStatus;
import com.example.taskMaster.infra.exceptions.CustomException;
import com.example.taskMaster.infra.repository.IRepository;

import java.util.UUID;

public class CannotChangeCompleteTask implements ICheckStatus {

    @Override
    public void validate(IRepository repository, UUID id) {
        var task = repository.get(id);

        if(task.getStatus().equals(Status.COMPLETE)) {
            throw new CustomException("Unable to change tasks already completed");
        }
    }
}
