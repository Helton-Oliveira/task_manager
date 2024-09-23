package com.example.taskMaster.infra.repository;

import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilder;
import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilderImpl;
import com.example.taskMaster.application.domain.components.Priority;
import com.example.taskMaster.application.domain.components.Status;
import com.example.taskMaster.application.domain.entities.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TaskRepositoryInMemory implements IRepository {

    private List<Task> taskList = new ArrayList<>();
    private TaskBuilder builder = new TaskBuilderImpl();

    @Override
    public Boolean save(Task task) {
        taskList.add(task);

        return !taskList.isEmpty();
    }

    @Override
    public Task get(UUID id) {

        return null;
    }

    @Override
    public List<Task> getAll() {
        fakeData();
        return taskList;
    }

    @Override
    public Boolean update(UUID id, Map<String, String> field) {
        return null;
    }

    private void fakeData() {

        List<Priority> priorityList = List.of(Priority.HIGH, Priority.MEDIUM, Priority.LOW);

        for (int i = 0; i <= 2; i++) {
            builder.setId(UUID.randomUUID());
            builder.setNameTask("name" + i);
            builder.setDescription("this description");
            builder.setPriority(priorityList.get(i));
            builder.setStatus(Status.TODO);
            builder.setCreatedAt(LocalDateTime.now());

            taskList.add(builder.getTask());
        }
    }
}
