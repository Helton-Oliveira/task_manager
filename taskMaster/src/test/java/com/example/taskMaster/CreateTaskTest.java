package com.example.taskMaster;

import com.example.taskMaster.adapter.repository.IConnection;
import com.example.taskMaster.adapter.repository.PostgreSqlAdapter;
import com.example.taskMaster.application.domain.builder.TaskBuilder;
import com.example.taskMaster.application.domain.builder.TaskBuilderImpl;
import com.example.taskMaster.application.usecase.CreateTask;
import com.example.taskMaster.application.usecase.GetToDoList;
import com.example.taskMaster.infra.repository.IRepository;
import com.example.taskMaster.infra.repository.TaskRepositoryDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateTaskTest {

    @Test
    @DisplayName("must create a task")
    void mustCreateATask() {
        IConnection connection = new PostgreSqlAdapter();
        IRepository repository = new TaskRepositoryDatabase(connection);
        TaskBuilder builder = new TaskBuilderImpl();
        var result = new CreateTask(repository, builder).execute();

        Assertions.assertNotNull(result);
    }


    @Test
    @DisplayName("must search for tasks")
    void mustSearchForTask() {
        IConnection connection = new PostgreSqlAdapter();
        IRepository repository = new TaskRepositoryDatabase(connection);
        TaskBuilder builder = new TaskBuilderImpl();
        var result = new GetToDoList(repository, builder).execute();

        System.out.println(result.toString());

        Assertions.assertNotNull(result.getFirst());
    }
}
