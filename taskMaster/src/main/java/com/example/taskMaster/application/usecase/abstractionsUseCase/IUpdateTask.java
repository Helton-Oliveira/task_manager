package com.example.taskMaster.application.usecase.abstractionsUseCase;

import java.util.Map;
import java.util.UUID;

public interface IUpdateTask {
    String execute(UUID id, Map<String, String> field);
}
