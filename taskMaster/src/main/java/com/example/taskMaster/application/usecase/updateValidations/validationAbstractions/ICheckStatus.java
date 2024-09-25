package com.example.taskMaster.application.usecase.updateValidations.validationAbstractions;

import com.example.taskMaster.infra.repository.IRepository;

import java.util.UUID;

public interface ICheckStatus {
    void validate(IRepository repository, UUID id);
}
