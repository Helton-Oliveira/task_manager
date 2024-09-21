package com.example.taskMaster.infra.repository;

import com.example.taskMaster.adapter.repository.IConnection;
import com.example.taskMaster.application.domain.Task;

import java.util.List;

public class TaskRepositoryDatabase implements IRepository {

    private final IConnection connection;

    public TaskRepositoryDatabase(IConnection connection) {
        this.connection = connection;
    }

    @Override
    public void save() {

    }

    @Override
    public Task get() {
        return null;
    }

    @Override
    public List<Task> getAll() {
        return List.of();
    }
}
