package com.example.taskMaster.application.usecase.creationValidations.concreteValidations;

import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.usecase.creationValidations.validationAbstractions.ICreationValidation;
import com.example.taskMaster.infra.exceptions.CustomException;

public class CheckFields implements ICreationValidation {
    @Override
    public void validate(Task task) {
        if (task.getNameTask().isEmpty()) {
            throw new CustomException("ERROR! Field 'NAME' cannot be null.");
        }

        if (task.getDueDate() == null) {
            throw new CustomException("ERROR! Field 'DUEDATE' cannot be null.");
        }

        if (task.getDescription().isEmpty()) {
            throw new CustomException("ERROR! Field 'DESCRIPTION' cannot be null.");
        }

    }
}
