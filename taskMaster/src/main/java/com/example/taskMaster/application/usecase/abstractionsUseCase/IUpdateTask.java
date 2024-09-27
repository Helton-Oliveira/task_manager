package com.example.taskMaster.application.usecase.abstractionsUseCase;

import com.example.taskMaster.adapter.dto.UpdateInput;

import java.util.Map;
import java.util.UUID;

public interface IUpdateTask {
    String execute(UUID id, UpdateInput updateInput);
}
