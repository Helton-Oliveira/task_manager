package com.example.taskMaster.application.usecase.updateValidations.validationAbstractions;

import java.util.Map;

public interface ICheckFieldData {
    void validate(Map<String, String> field);

}
