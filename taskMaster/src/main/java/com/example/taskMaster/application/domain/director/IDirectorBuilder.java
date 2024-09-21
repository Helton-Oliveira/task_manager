package com.example.taskMaster.application.domain.director;

import java.time.LocalDate;

public interface IDirectorBuilder {
    void createEasyLevelTask(String nameTask, String description, LocalDate dueDate);
    void createMediumLevelTask(String nameTask, String description, LocalDate dueDate);
    void createDifficultLevelTask(String nameTask, String description, LocalDate dueDate);
}
