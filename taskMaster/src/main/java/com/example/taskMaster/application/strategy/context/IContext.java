package com.example.taskMaster.application.strategy.context;

import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.strategy.strategies.Strategy;

import java.time.LocalDate;

public interface IContext {
    void setStrategy(Strategy strategy);
    Task executeStrategy(String nameTask, String description, LocalDate dueDate);
}
