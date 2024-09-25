package com.example.taskMaster.application.usecase.updateValidations.concreteValidations;

import com.example.taskMaster.application.usecase.updateValidations.validationAbstractions.ICheckFieldData;
import com.example.taskMaster.infra.exceptions.CustomException;

import java.util.Map;

public class CheckFieldData implements ICheckFieldData {
    @Override
    public void validate(Map<String, String> field) {
        if (isNullField(field) || isEmptyField(field)) {
            throw new CustomException("ERROR! Field cannot be null or empty");
        }
    }

    private Boolean isEmptyField(Map<String, String> field) {
        return field.isEmpty() || field.get("status").isEmpty() || field.get("status").isEmpty();
    }

    private Boolean isNullField(Map<String, String> field) {
        return field == null || field.get("status") == null || field.get("status") == null;
    }
}
