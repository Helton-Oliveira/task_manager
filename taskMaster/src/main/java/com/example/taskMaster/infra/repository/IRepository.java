package com.example.taskMaster.infra.repository;

import com.example.taskMaster.application.domain.entities.Task;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IRepository {
    Boolean save(Task task);
    Task get(UUID id);
    List<Task> getAll();
    Boolean update(UUID id, Map<String, String> field);

}
