package com.example.taskMaster.application.usecase.abstractions;

import com.example.taskMaster.application.domain.entities.Task;

import java.util.List;

public interface IGetToDoList {
    List<Task> execute();
}
