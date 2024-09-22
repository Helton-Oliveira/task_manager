package com.example.taskMaster.application.strategy.context;

import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.strategy.strategies.Strategy;

import java.time.LocalDate;

public class Context implements IContext {

    private Strategy strategy;

    @Override
    public void setStrategy(Strategy strategy) {
         this.strategy = strategy;
    }

    @Override
    public Task executeStrategy(String nameTask, String description, LocalDate dueDate) {
        return strategy.execute(nameTask, description, dueDate);
    }
}
