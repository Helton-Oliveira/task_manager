package com.example.taskMaster.application.usecase.creationValidations.validationAbstractions;

import com.example.taskMaster.application.domain.entities.Task;

public interface ICreationValidation {
   void validate(Task task);
}
