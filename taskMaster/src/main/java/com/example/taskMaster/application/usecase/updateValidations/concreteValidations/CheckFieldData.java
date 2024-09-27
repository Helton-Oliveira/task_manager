package com.example.taskMaster.application.usecase.updateValidations.concreteValidations;

import com.example.taskMaster.application.usecase.updateValidations.validationAbstractions.ICheckFieldData;
import com.example.taskMaster.infra.exceptions.CustomException;

import java.util.Map;

public class CheckFieldData implements ICheckFieldData {
    @Override
    public void validate(Map<String, String> field) {
        if (isNullOrEmpty(field)) {
            throw new CustomException("ERROR! Field cannot be null or empty");
        }

        if (field.containsKey("duedate") &&dueDateIsNUllOrEmpty(field)) {
            throw new CustomException("ERROR! the DueDate field cannot be empty or null");
        }

        if (field.containsKey("status") && statusIsNullOrEmpty(field)) {
            throw new CustomException("ERROR! the status field cannot be empty or null");
        }
    }

    private Boolean statusIsNullOrEmpty(Map<String, String> field) {
        return  field.get("status") == null || field.get("status").isEmpty();
    }

    private Boolean dueDateIsNUllOrEmpty(Map<String, String> field) {
        return field.get("duedate") == null || field.get("duedate").isEmpty();
    }

    private Boolean isNullOrEmpty(Map<String, String> field) {
        return field.isEmpty() || field == null;
    }
}
