package com.example.taskMaster.application.bridge;

import com.example.taskMaster.adapter.dto.UpdateInput;
import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.usecase.abstractionsUseCase.ICreateTask;
import com.example.taskMaster.application.usecase.abstractionsUseCase.IGetTask;
import com.example.taskMaster.application.usecase.abstractionsUseCase.IGetToDoList;
import com.example.taskMaster.application.usecase.abstractionsUseCase.IUpdateTask;

import java.util.List;
import java.util.UUID;

public class ServiceOperation implements IAbstractOperation {

    private final ICreateTask createTask;
    private final IGetToDoList getToDoList;
    private final IGetTask getTask;
    private final IUpdateTask updateTask;

    public ServiceOperation(ICreateTask createTask, IGetToDoList getToDoList, IGetTask getTask, IUpdateTask updateTask) {

        this.createTask = createTask;
        this.getToDoList = getToDoList;
        this.getTask = getTask;
        this.updateTask = updateTask;
    }

    @Override
    public Boolean runTaskCreation(Integer priority, String nameTask, String description, String dueDate) {
        return createTask.execute(priority, nameTask, description, dueDate);
    }

    @Override
    public List<Task> runSearchAll() {
        return getToDoList.execute();
    }

    @Override
    public Task runSearchOne(UUID id) {
        return getTask.execute(id);
    }

    @Override
    public String runUpdate(UUID id,UpdateInput updateInput) {
        return updateTask.execute(id, updateInput);
    }

}
