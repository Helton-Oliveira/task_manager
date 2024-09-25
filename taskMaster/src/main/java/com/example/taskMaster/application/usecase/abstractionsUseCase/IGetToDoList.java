package com.example.taskMaster.application.usecase.abstractionsUseCase;

import com.example.taskMaster.application.domain.entities.Task;

import java.util.List;

public interface IGetToDoList {
    List<Task> execute();
}
