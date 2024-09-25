package com.example.taskMaster.infra.repository;

import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilder;
import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilderImpl;
import com.example.taskMaster.application.domain.components.Priority;
import com.example.taskMaster.application.domain.components.Status;
import com.example.taskMaster.application.domain.entities.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TaskRepositoryInMemory implements IRepository {

    private List<Task> taskList = new ArrayList<>();
    private TaskBuilder builder = new TaskBuilderImpl();

    @Override
    public Boolean save(Task task) {
        taskList.add(task);

        return !taskList.isEmpty();
    }

    @Override
    public Task get(UUID id) {
        fakeData();
        var task = taskList.stream()
                .filter(t -> t.getId().equals(id))
                .map(t -> fakeTask(t.getId(), t.getNameTask(), t.getDescription(), t.getPriority(), t.getStatus()))
                .toList();

        return task.getFirst();
    }

    @Override
    public List<Task> getAll() {
        fakeData();
        return taskList;
    }

    @Override
    public Boolean update(UUID id, Map<String, String> field) {
        return null;
    }

    private void fakeData() {

        List<Priority> priorityList = List.of(Priority.HIGH, Priority.MEDIUM, Priority.LOW);
        List<Status> statusList = List.of(Status.TODO, Status.COMPLETE, Status.DOING);
        List<String> uuidList = List.of("6d6c20d4-4764-4255-8b34-5c49f57f33d3", "45b8e919-ecc7-486d-8822-1e5683788f29", "5ff56424-c7dd-4b80-bd57-7f1965744033");

        for (int i = 0; i <= 2; i++) {
            builder.setId(UUID.fromString(uuidList.get(i)));
            builder.setNameTask("name" + i);
            builder.setDescription("this description");
            builder.setPriority(priorityList.get(i));
            builder.setStatus(statusList.get(i));
            builder.setCreatedAt(LocalDateTime.now());

            taskList.add(builder.getTask());
            builder.reset();

        }
    }

    private Task fakeTask(UUID id, String name, String description, Priority priority, Status status) {
        builder.setId(id);
        builder.setNameTask(name);
        builder.setDescription(description);
        builder.setPriority(priority);
        builder.setStatus(status);
        builder.setCreatedAt(LocalDateTime.now());

        return builder.getTask();
    }
}
