package com.example.taskMaster.application.strategy.strategies;

import com.example.taskMaster.application.domain.entities.Task;

import java.time.LocalDate;

public interface Strategy {
    Task execute(String nameTask, String description, LocalDate dueDate);
}
