package com.example.taskMaster.application.usecase.creationValidations;

import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.infra.exceptions.CustomException;


public class ValidateDate implements ICreationValidation {
    @Override
    public void validate(Task task) {
        var dueDate = task.getDueDate();
        var dateOfCriation = task.getCreatedAt().toLocalDate();

        if (dueDate.isBefore(dateOfCriation) || dueDate.equals(dateOfCriation)) {
            throw new CustomException("Error! Invalid date.");
        }

    }
}
