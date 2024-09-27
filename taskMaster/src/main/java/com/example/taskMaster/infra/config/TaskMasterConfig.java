package com.example.taskMaster.infra.config;

import com.example.taskMaster.adapter.repository.IConnection;
import com.example.taskMaster.adapter.repository.PostgreSqlAdapter;
import com.example.taskMaster.application.bridge.ServiceOperation;
import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilder;
import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilderImpl;
import com.example.taskMaster.application.strategy.CreateByStrategy;
import com.example.taskMaster.application.strategy.ICreateByStrategy;
import com.example.taskMaster.application.strategy.context.Context;
import com.example.taskMaster.application.strategy.context.IContext;
import com.example.taskMaster.application.strategy.strategies.StrategyEasyTask;
import com.example.taskMaster.application.strategy.strategies.StrategyHighTask;
import com.example.taskMaster.application.strategy.strategies.StrategyMediumTask;
import com.example.taskMaster.application.usecase.abstractionsUseCase.ICreateTask;
import com.example.taskMaster.application.usecase.abstractionsUseCase.IGetTask;
import com.example.taskMaster.application.usecase.abstractionsUseCase.IGetToDoList;
import com.example.taskMaster.application.usecase.abstractionsUseCase.IUpdateTask;
import com.example.taskMaster.application.usecase.concreteUseCases.CreateTask;
import com.example.taskMaster.application.usecase.concreteUseCases.GetTask;
import com.example.taskMaster.application.usecase.concreteUseCases.GetToDoList;
import com.example.taskMaster.application.usecase.concreteUseCases.UpdateTask;
import com.example.taskMaster.application.usecase.creationValidations.concreteValidations.CheckFields;
import com.example.taskMaster.application.usecase.creationValidations.concreteValidations.ValidateDate;
import com.example.taskMaster.application.usecase.creationValidations.validationAbstractions.ICreationValidation;
import com.example.taskMaster.application.usecase.updateValidations.concreteValidations.CannotChangeCompleteTask;
import com.example.taskMaster.application.usecase.updateValidations.concreteValidations.CheckFieldData;
import com.example.taskMaster.application.usecase.updateValidations.concreteValidations.UpdateValidations;
import com.example.taskMaster.application.usecase.updateValidations.validationAbstractions.IUpdateValidation;
import com.example.taskMaster.infra.repository.IRepository;
import com.example.taskMaster.infra.repository.TaskRepositoryDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TaskMasterConfig {

    @Bean
    TaskRepositoryDatabase taskRepositoryDatabase(IConnection connection, TaskBuilder builder) {
        return new TaskRepositoryDatabase(connection, builder);
    }

    @Bean
    PostgreSqlAdapter postgreSqlAdapter() {
        return new PostgreSqlAdapter();
    }

    @Bean
    TaskBuilderImpl taskBuilder() {
        return new TaskBuilderImpl();
    }

    @Bean
    CreateTask createTask(IRepository repository, ICreateByStrategy create, List<ICreationValidation> validationList){
        return new CreateTask(repository, create, validationList);
    }
    @Bean
    GetTask getTask(IRepository repository) {
        return new GetTask(repository);
    }

    @Bean
    GetToDoList getToDoList(IRepository repository) {
        return new GetToDoList(repository);
    }

    @Bean
    UpdateTask updateTask(IRepository repository, IUpdateValidation updateValidationsList) {
        return new UpdateTask(repository, updateValidationsList);
    }

    @Bean
    StrategyEasyTask strategyEasyTask() {
        return new StrategyEasyTask();
    }

    @Bean
    StrategyHighTask strategyHighTask() {
        return new StrategyHighTask();
    }

    @Bean
    StrategyMediumTask strategyMediumTask() {
        return new StrategyMediumTask();
    }

    @Bean
    CreateByStrategy create(IContext context) {
        return new CreateByStrategy(context);
    }

    @Bean
    Context context() {
        return new Context();
    }

    @Bean
    ServiceOperation serviceOperation(ICreateTask createTask, IGetToDoList getToDoList, IGetTask getTask, IUpdateTask updateTask) {
        return new ServiceOperation(createTask, getToDoList, getTask, updateTask);
    }

    @Bean
    UpdateValidations updateValidations() {
        return new UpdateValidations();
    }

    @Bean
    CheckFields checkFields() {
        return new CheckFields();
    }

    @Bean
    ValidateDate validateDate() {
        return new ValidateDate();
    }

    @Bean
    CannotChangeCompleteTask cannotChangeCompleteTask() {
        return new CannotChangeCompleteTask();
    }

    @Bean
    CheckFieldData checkFieldData() {
        return new CheckFieldData();
    }
}
