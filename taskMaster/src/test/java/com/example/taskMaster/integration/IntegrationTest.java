package com.example.taskMaster.integration;

import com.example.taskMaster.adapter.repository.IConnection;
import com.example.taskMaster.adapter.repository.PostgreSqlAdapter;
import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilder;
import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilderImpl;
import com.example.taskMaster.application.domain.components.Status;
import com.example.taskMaster.application.strategy.CreateByStrategy;
import com.example.taskMaster.application.strategy.ICreateByStrategy;
import com.example.taskMaster.application.strategy.context.Context;
import com.example.taskMaster.application.usecase.concreteUseCases.CreateTask;
import com.example.taskMaster.application.usecase.concreteUseCases.GetTask;
import com.example.taskMaster.application.usecase.concreteUseCases.GetToDoList;
import com.example.taskMaster.application.usecase.concreteUseCases.UpdateTask;
import com.example.taskMaster.application.usecase.creationValidations.concreteValidations.CheckFields;
import com.example.taskMaster.application.usecase.creationValidations.validationAbstractions.ICreationValidation;
import com.example.taskMaster.application.usecase.creationValidations.concreteValidations.ValidateDate;
import com.example.taskMaster.application.usecase.updateValidations.validationAbstractions.IUpdateValidation;
import com.example.taskMaster.application.usecase.updateValidations.concreteValidations.UpdateValidations;
import com.example.taskMaster.infra.repository.IRepository;
import com.example.taskMaster.infra.repository.TaskRepositoryDatabase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest {

    @Test
    @DisplayName("must create a task")
    void mustCreateATask() {
        IConnection connection = new PostgreSqlAdapter();
        TaskBuilder builder = new TaskBuilderImpl();
        IRepository repository = new TaskRepositoryDatabase(connection, builder);
        ICreateByStrategy byStrategy = new CreateByStrategy(new Context());
        List<ICreationValidation> validationList = List.of(new ValidateDate(), new CheckFields());
        var result = new CreateTask(repository, byStrategy, validationList).execute(1, "Dar comida ao cachorro", "Comida para o cachorro", "2024-09-24");

        assertThat(result.booleanValue()).isEqualTo(true);
    }

    @Test
    @DisplayName("should return all tasks that are not completed")
    void mustSearchForTask() {
        IConnection connection = new PostgreSqlAdapter();
        TaskBuilder builder = new TaskBuilderImpl();
        IRepository repository = new TaskRepositoryDatabase(connection, builder);
        var result = new GetToDoList(repository).execute();

        result.forEach(t -> {
            System.out.println(t.toString());
            assertThat(t.getStatus()).isNotEqualTo("COMPLETE");
        });
    }

    @Test
    @DisplayName("must be return a task")
    void mustReturnATask() {
        IConnection connection = new PostgreSqlAdapter();
        TaskBuilder builder = new TaskBuilderImpl();
        IRepository repository = new TaskRepositoryDatabase(connection, builder);
        var result = new GetTask(repository).execute(UUID.fromString("34cf2939-a88d-4261-9dc9-92715860ad6a"));
        System.out.println(result.toString());
        assertThat(result.getNameTask()).isEqualTo("Estudar mais sobre design patterns");
    }

    @Test
    @DisplayName("must update the task in the status field")
    void mustUpdateTheStatus() {
        IConnection connection = new PostgreSqlAdapter();
        TaskBuilder builder = new TaskBuilderImpl();
        IRepository repository = new TaskRepositoryDatabase(connection, builder);
        IUpdateValidation validation = new UpdateValidations();
        var result = new UpdateTask(repository, validation).execute(UUID.fromString("ae87ad96-697c-4d1f-abe3-32cca8f6bf2f"), Map.of("status", String.valueOf(Status.COMPLETE)));

        assertThat(result).isEqualTo("update completed successfully");
    }

    @Test
    @DisplayName("must update the due date field")
    void mustUpdateTheDueDate() {
        IConnection connection = new PostgreSqlAdapter();
        TaskBuilder builder = new TaskBuilderImpl();
        IRepository repository = new TaskRepositoryDatabase(connection, builder);
        IUpdateValidation validation = new UpdateValidations();
        var result = new UpdateTask(repository, validation).execute(UUID.fromString("34cf2939-a88d-4261-9dc9-92715860ad6a"), Map.of("duedate", "2024-09-24"));

        assertThat(result).isEqualTo("update completed successfully");
    }

}
