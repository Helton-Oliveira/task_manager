package com.example.taskMaster.application.usecase.updateValidations.concreteValidations;

import com.example.taskMaster.application.usecase.updateValidations.validationAbstractions.IUpdateValidation;
import com.example.taskMaster.infra.repository.IRepository;

import java.util.Map;
import java.util.UUID;

public class UpdateValidations implements IUpdateValidation {

    @Override
    public void validate(Map<String, String> field, IRepository repository, UUID id) {
        new CannotChangeCompleteTask().validate(repository, id);
        new CheckFieldData().validate(field);
    }
}
