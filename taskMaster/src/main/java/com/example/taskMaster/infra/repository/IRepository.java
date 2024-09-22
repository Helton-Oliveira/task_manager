package com.example.taskMaster.infra.repository;

import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilder;
import com.example.taskMaster.application.domain.entities.Task;

import java.util.List;

public interface IRepository {
    Boolean save(Task task);
    Task get();
    List<Task> getAll(TaskBuilder builder);

}
