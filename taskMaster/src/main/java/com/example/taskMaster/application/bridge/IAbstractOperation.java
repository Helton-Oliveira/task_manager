package com.example.taskMaster.application.bridge;


import com.example.taskMaster.adapter.dto.UpdateInput;
import com.example.taskMaster.application.domain.entities.Task;

import java.util.List;
import java.util.UUID;

public interface IAbstractOperation {
    Boolean runTaskCreation(Integer priority,String nameTask, String description, String dueDate);
    List<Task> runSearchAll();
    Task runSearchOne(UUID id);
    String runUpdate(UUID id,UpdateInput updateInput);
}
