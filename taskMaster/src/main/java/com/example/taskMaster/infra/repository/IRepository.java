package com.example.taskMaster.infra.repository;

import com.example.taskMaster.application.domain.Task;

import java.util.List;

public interface IRepository {
    void save();
    Task get();
    List<Task> getAll();

}
