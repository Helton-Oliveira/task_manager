package com.example.taskMaster.application.usecase.updateValidations.validationAbstractions;

import com.example.taskMaster.infra.repository.IRepository;

import java.util.Map;
import java.util.UUID;

public interface IUpdateValidation {
    void validate(Map<String, String> field, IRepository repository, UUID id);
}
