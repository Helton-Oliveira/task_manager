package com.example.taskMaster.infra.repository;

import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.domain.entities.abstractions.RebuildTask;

import java.util.List;

public interface IRepository {
    Boolean save(Task task);
    Task get();
    List<Task> getAll(RebuildTask rebuildTask);

}
