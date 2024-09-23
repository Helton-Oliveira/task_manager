package com.example.taskMaster.application.usecase.abstractions;

import org.springframework.boot.autoconfigure.mail.MailProperties;

import java.util.Map;
import java.util.UUID;

public interface IUpdateTask {
    String execute(UUID id, Map<String, String> field);
}
