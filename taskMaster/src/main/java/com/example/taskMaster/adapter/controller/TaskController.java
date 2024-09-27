package com.example.taskMaster.adapter.controller;

import com.example.taskMaster.adapter.dto.Input;
import com.example.taskMaster.adapter.dto.Output;
import com.example.taskMaster.adapter.dto.UpdateInput;
import com.example.taskMaster.application.bridge.IAbstractOperation;
import com.example.taskMaster.infra.exceptions.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {

    public final IAbstractOperation operation;

    public TaskController(IAbstractOperation operation) {
        this.operation = operation;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Output> getTask(@PathVariable UUID id) {
        var task = operation.runSearchOne(id);
        return ResponseEntity.ok(new Output(task));
    }

    @GetMapping
    public ResponseEntity<List<Output>> getAllTasks() {
        var outputList = operation.runSearchAll().stream()
                .map(Output::new).toList();
        return ResponseEntity.ok(outputList);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> createTask(@RequestBody Input data) {
        operation.runTaskCreation(data.priority(), data.name(), data.description(), data.dueDate());
        return ResponseEntity.ok("successfully created");
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateTasks(@RequestBody UpdateInput updateInput, @PathVariable UUID id ) {
        operation.runUpdate(id, updateInput);
        return ResponseEntity.ok("task changed successfully");
    }

}
