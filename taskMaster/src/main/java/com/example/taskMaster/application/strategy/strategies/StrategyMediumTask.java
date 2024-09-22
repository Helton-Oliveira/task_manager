package com.example.taskMaster.application.strategy.strategies;

import com.example.taskMaster.application.domain.builderPattern.director.DirectorBuilder;
import com.example.taskMaster.application.domain.entities.Task;

import java.time.LocalDate;

public class StrategyMediumTask implements Strategy{
    @Override
    public Task execute(String nameTask, String description, LocalDate dueDate) {

        var mediumTask = DirectorBuilder.createDirector();
        mediumTask.createMediumLevelTask(nameTask, description, dueDate);
        return mediumTask.build();
    }
}
