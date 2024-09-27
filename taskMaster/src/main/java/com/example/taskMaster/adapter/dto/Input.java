package com.example.taskMaster.adapter.dto;

public record Input(
        String name,
        String description,
        Integer priority,
        String dueDate
) {
}
