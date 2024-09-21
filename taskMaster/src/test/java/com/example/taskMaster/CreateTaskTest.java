package com.example.taskMaster;

import com.example.taskMaster.adapter.repository.IConnection;
import com.example.taskMaster.adapter.repository.PostgreSqlAdapter;
import com.example.taskMaster.application.usecase.CreateTask;
import com.example.taskMaster.application.usecase.GetTask;
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
        new CreateTask(repository).execute();

        var task = new GetTask(repository).execute();

        Assertions.assertNotNull(task.getId());
    }
}
