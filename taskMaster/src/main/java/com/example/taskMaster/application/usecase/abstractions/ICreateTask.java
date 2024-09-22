package com.example.taskMaster.application.usecase.abstractions;

public interface ICreateTask {
    Boolean execute(Integer priority ,String nameTask, String description, String dueDate);
}
