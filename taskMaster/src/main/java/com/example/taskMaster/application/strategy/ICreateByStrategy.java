package com.example.taskMaster.application.strategy;

import com.example.taskMaster.application.domain.entities.Task;

import java.time.LocalDate;

public interface ICreateByStrategy {
    Task create(Integer priority, String nameTask, String description, LocalDate dueDate);
}
