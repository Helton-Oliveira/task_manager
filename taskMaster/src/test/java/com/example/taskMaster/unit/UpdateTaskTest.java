package com.example.taskMaster.unit;

import com.example.taskMaster.application.domain.components.Status;
import com.example.taskMaster.application.usecase.updateValidations.concreteValidations.UpdateValidations;
import com.example.taskMaster.infra.exceptions.CustomException;
import com.example.taskMaster.infra.repository.TaskRepositoryInMemory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UpdateTaskTest {

    @Test
    @DisplayName("should return exception if invalid data is available for update")
    void exceptionIfInvalidData() {
        var repository = new TaskRepositoryInMemory();
        Map field = new HashMap<>();
        field.put("", Status.TODO);
        var validator = new UpdateValidations();

        CustomException exception = assertThrows(CustomException.class, () -> {
            validator.validate(field, repository, UUID.fromString("6d6c20d4-4764-4255-8b34-5c49f57f33d3"));
        });

        assertThat(exception.getMessage()).isEqualTo("ERROR! Field cannot be null or empty");
    }

    @Test
    @DisplayName("must return an exception if you want to change the task with status 'COMPLETE'")
    void exceptionCaseValidation() {
        var repository = new TaskRepositoryInMemory();
        Map field = new HashMap<>();
        field.put("status", Status.TODO);
        var validator = new UpdateValidations();

        CustomException exception = assertThrows(CustomException.class, () -> {
            validator.validate(field, repository, UUID.fromString("45b8e919-ecc7-486d-8822-1e5683788f29"));
        });

        assertThat(exception.getMessage()).isEqualTo("Unable to change tasks already completed");
    }
}
