package com.example.taskMaster.integration;

import com.example.taskMaster.adapter.repository.IConnection;
import com.example.taskMaster.adapter.repository.PostgreSqlAdapter;
import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilder;
import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilderImpl;
import com.example.taskMaster.application.domain.components.Status;
import com.example.taskMaster.application.strategy.CreateByStrategy;
import com.example.taskMaster.application.strategy.ICreateByStrategy;
import com.example.taskMaster.application.strategy.context.Context;
import com.example.taskMaster.application.usecase.CreateTask;
import com.example.taskMaster.application.usecase.GetTask;
import com.example.taskMaster.application.usecase.GetToDoList;
import com.example.taskMaster.application.usecase.UpdateTask;
import com.example.taskMaster.infra.repository.IRepository;
import com.example.taskMaster.infra.repository.TaskRepositoryDatabase;
import com.example.taskMaster.infra.repository.TaskRepositoryInMemory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        var result = new CreateTask(repository, byStrategy).execute(2, "Ir a academia", "Acordar cedo para ir a academia", "2024-09-23");

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
        var result = new UpdateTask(repository).execute(UUID.fromString("58235b86-b1e5-4c7c-96e2-e0be26add4e0"), Map.of("status", String.valueOf(Status.COMPLETE)));

        assertThat(result).isEqualTo("update completed successfully");
    }

    @Test
    @DisplayName("must update the due date field")
    void mustUpdateTheDueDate() {
        IConnection connection = new PostgreSqlAdapter();
        TaskBuilder builder = new TaskBuilderImpl();
        IRepository repository = new TaskRepositoryDatabase(connection, builder);
        var result = new UpdateTask(repository).execute(UUID.fromString("34cf2939-a88d-4261-9dc9-92715860ad6a"), Map.of("duedate", "2024-09-24"));

        assertThat(result).isEqualTo("update completed successfully");
    }

}
