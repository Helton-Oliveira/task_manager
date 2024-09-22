package com.example.taskMaster.application.strategy;

import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.strategy.context.IContext;
import com.example.taskMaster.application.strategy.strategies.StrategyEasyTask;
import com.example.taskMaster.application.strategy.strategies.StrategyHighTask;
import com.example.taskMaster.application.strategy.strategies.StrategyMediumTask;

import java.time.LocalDate;

public class CreateByStrategy implements ICreateByStrategy {

    private final IContext context;

    public CreateByStrategy(IContext context) {
        this.context = context;
    }

    @Override
    public Task create(Integer priority, String nameTask, String description, LocalDate dueDate) {

        if (priority.equals(1)) {
            context.setStrategy(new StrategyHighTask());
        }

        if (priority.equals(2)) {
            context.setStrategy(new StrategyMediumTask());
        }

        if (priority.equals(3)) {
            context.setStrategy(new StrategyEasyTask());
        }

        return context.executeStrategy(nameTask, description, dueDate);
    }
}
