package com.example.taskMaster.adapter.controller;

import com.example.taskMaster.adapter.dto.Input;
import com.example.taskMaster.adapter.dto.Output;
import com.example.taskMaster.application.usecase.abstractionsUseCase.ICreateTask;
import com.example.taskMaster.application.usecase.abstractionsUseCase.IGetTask;
import com.example.taskMaster.application.usecase.abstractionsUseCase.IGetToDoList;
import com.example.taskMaster.application.usecase.abstractionsUseCase.IUpdateTask;
import com.example.taskMaster.infra.exceptions.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    public final ICreateTask createTask;
    public final IGetTask getTask;
    public final IGetToDoList getToDoList;
    public final IUpdateTask updateTask;

    public TaskController(ICreateTask createTask, IGetTask getTask, IGetToDoList getToDoList, IUpdateTask iUpdateTask) {
        this.createTask = createTask;
        this.getTask = getTask;
        this.getToDoList = getToDoList;
        this.updateTask = iUpdateTask;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Output> getTask(@PathVariable UUID id) {
        var task = getTask.execute(id);

        return ResponseEntity.ok(new Output(task));
    }

    @GetMapping
    public ResponseEntity<List<Output>> getAllTasks() {
        var outputList = getToDoList.execute().stream()
                .map(Output::new).toList();
        return ResponseEntity.ok(outputList);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> createTask(@RequestBody Input data) {
        if (!createTask.execute(data.priority(), data.name(), data.description(), data.dueDate())) throw new CustomException("error creating task");
        return ResponseEntity.ok("successfully created");
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateTasks(@RequestBody Map<String, String> field, @PathVariable UUID id ) {
        updateTask.execute(id, field);
        return ResponseEntity.ok("task changed successfully");
    }

}
