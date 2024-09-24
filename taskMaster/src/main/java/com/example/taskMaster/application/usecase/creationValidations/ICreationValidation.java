package com.example.taskMaster.application.usecase.creationValidations;

import com.example.taskMaster.application.domain.entities.Task;

public interface ICreationValidation {
   void validate(Task task);
}
