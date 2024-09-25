package com.example.taskMaster.unit;

import com.example.taskMaster.application.domain.builderPattern.director.DirectorBuilder;
import com.example.taskMaster.application.usecase.creationValidations.validationAbstractions.ICreationValidation;
import com.example.taskMaster.application.usecase.creationValidations.concreteValidations.ValidateDate;
import com.example.taskMaster.application.usecase.creationValidations.concreteValidations.CheckFields;
import com.example.taskMaster.infra.exceptions.CustomException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateTaskTest {

    @Test
    @DisplayName("Should throw an exception when creating a task if the date is less than the current date")
    void shouldReturnExceptionIfDateSmaller() {

        var creator = DirectorBuilder.createDirector();
        creator.createDifficultLevelTask("Montar movel", "realizar montagem de movel conforme solicitado pelo cliente", LocalDate.parse("2024-09-22"));
        var task = creator.build();

        ICreationValidation validateDate = new ValidateDate();

        CustomException exception = assertThrows(CustomException.class, () -> {
            validateDate.validate(task);
        });

        assertThat(exception.getMessage()).isEqualTo("Error! Invalid date.");
    }

    @Test
    @DisplayName("Should throw an exception when creating a task if the date is equal to the current date")
    void shouldReturnExceptionIfDateEquals() {

        var creator = DirectorBuilder.createDirector();
        creator.createDifficultLevelTask("Montar movel", "realizar montagem de movel conforme solicitado pelo cliente", LocalDate.now());
        var task = creator.build();

        ICreationValidation validateDate = new ValidateDate();

        CustomException exception = assertThrows(CustomException.class, () -> {
            validateDate.validate(task);
        });

        assertThat(exception.getMessage()).isEqualTo("Error! Invalid date.");
    }

    @Test
    @DisplayName("should return an exception if any field is null or empty")
    void verifyNameField() {

        var creator = DirectorBuilder.createDirector();
        creator.createDifficultLevelTask("", "FRFR", LocalDate.parse("2222-12-22"));
        var task = creator.build();

        ICreationValidation verifyNullFields = new CheckFields();

        CustomException exception = assertThrows(CustomException.class, () -> {
            verifyNullFields.validate(task);
        });

        assertThat(exception.getMessage()).isEqualTo("ERROR! Field 'NAME' cannot be null.");
    }

    @Test
    @DisplayName("should return an exception if any field is null or empty")
    void verifyDescriptionField() {

        var creator = DirectorBuilder.createDirector();
        creator.createDifficultLevelTask("Tarefa qualquer", "", LocalDate.parse("2222-12-22"));
        var task = creator.build();

        ICreationValidation verifyNullFields = new CheckFields();

        CustomException exception = assertThrows(CustomException.class, () -> {
            verifyNullFields.validate(task);
        });

        assertThat(exception.getMessage()).isEqualTo("ERROR! Field 'DESCRIPTION' cannot be null.");
    }

    @Test
    @DisplayName("should return an exception if any field is null or empty")
    void verifyDueDateField() {

        var creator = DirectorBuilder.createDirector();
        creator.createDifficultLevelTask("Tarefa qualquer", "description", null);
        var task = creator.build();

        ICreationValidation verifyNullFields = new CheckFields();

        CustomException exception = assertThrows(CustomException.class, () -> {
            verifyNullFields.validate(task);
        });

        assertThat(exception.getMessage()).isEqualTo("ERROR! Field 'DUEDATE' cannot be null.");
    }


}
