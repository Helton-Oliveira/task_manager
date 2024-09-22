package com.example.taskMaster;

import com.example.taskMaster.adapter.repository.IConnection;
import com.example.taskMaster.adapter.repository.PostgreSqlAdapter;
import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilder;
import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilderImpl;
import com.example.taskMaster.application.strategy.CreateByStrategy;
import com.example.taskMaster.application.strategy.ICreateByStrategy;
import com.example.taskMaster.application.strategy.context.Context;
import com.example.taskMaster.application.usecase.CreateTask;
import com.example.taskMaster.application.usecase.GetToDoList;
import com.example.taskMaster.infra.repository.IRepository;
import com.example.taskMaster.infra.repository.TaskRepositoryDatabase;
import com.example.taskMaster.infra.repository.TaskRepositoryInMemory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTaskTest {

    @Test
    @DisplayName("must create a task")
    void mustCreateATask() {
        //IConnection connection = new PostgreSqlAdapter();
        IRepository repository = new TaskRepositoryInMemory();
        ICreateByStrategy byStrategy = new CreateByStrategy(new Context());
        var result = new CreateTask(repository, byStrategy).execute(1, "Estudar mais sobre design patterns", "comprar o livro do refactoring guru", "2024-09-23");

        assertThat(result.booleanValue()).isEqualTo(true);
    }


    @Test
    @DisplayName("must search for tasks")
    void mustSearchForTask() {
        //IConnection connection = new PostgreSqlAdapter();
        IRepository repository = new TaskRepositoryInMemory();
        TaskBuilder builder = new TaskBuilderImpl();
        var result = new GetToDoList(repository, builder).execute();

        System.out.println(result.toString());

        Assertions.assertNotNull(result.getFirst());
    }
}
