package com.example.taskMaster.infra.repository;

import com.example.taskMaster.adapter.repository.IConnection;
import com.example.taskMaster.application.domain.builderPattern.builder.TaskBuilder;
import com.example.taskMaster.application.domain.components.Priority;
import com.example.taskMaster.application.domain.components.Status;
import com.example.taskMaster.application.domain.entities.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TaskRepositoryDatabase implements IRepository {

    private final IConnection connection;
    private final TaskBuilder builder;

    public TaskRepositoryDatabase(IConnection connection, TaskBuilder builder) {
        this.connection = connection;
        this.builder = builder;
    }

    @Override
    public Boolean save(Task task) {

        try {
            var st = connection.query("INSERT INTO tasks (id, nametask, description, status, priority, duedate, createdat) VALUES (?, ?, ?, ?, ?, ?, ?)");
            build(st, task);
            var result = st.executeUpdate();

            if(result != 0) {
                return true;
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public Task get(UUID id) {

        try {
            var st = connection.query("SELECT * FROM tasks WHERE id = ?");
            st.setObject(1, id);
            var result = st.executeQuery();
            if (result.next()) {
                rebuild(result);
                return builder.getTask();
            }
            connection.close();
        } catch (SQLException e) {
            e.getMessage();
        }

        return null;
    }

    @Override
    public List<Task> getAll() {
        List<Task> taskList = new ArrayList<>();

        try {
            var st = connection.query("SELECT * FROM tasks WHERE status IN ('DOING', 'TODO')");
            var result = st.executeQuery();
            while (result.next()) {
                builder.reset();
                rebuild(result);
                taskList.add(builder.getTask());
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return taskList;
    }

    @Override
    public Boolean update(UUID id, Map<String, String> field) {

        String sql = "";

        if(field.containsKey("duedate")) {
            sql = "UPDATE tasks SET duedate = ? WHERE id = ?";
        }

        if(field.containsKey("status")) {
            sql = "UPDATE tasks SET status = ? WHERE id = ?";
        }

        try {
            System.out.println(sql);
            var st = connection.query(sql);
            chooseTheNewFieldData(st, field);
            st.setObject(2, id);
            var result = st.executeQuery();
            if (!result.next()) {
                rebuild(result);
                return false;
            }
            connection.close();
        } catch (SQLException e) {
            e.getMessage();
        }

        return true;
    }

    private void chooseTheNewFieldData(PreparedStatement st, Map<String, String> field) throws SQLException {
        if(field.containsKey("duedate")) {
            st.setDate(1, Date.valueOf(field.get("duedate")));

        }

        if(field.containsKey("status")) {
            st.setString(1, String.valueOf(field.get("status")));
        }
    }

    private void build (PreparedStatement st, Task task) throws SQLException {
        st.setObject(1, task.getId());
        st.setString(2, task.getNameTask());
        st.setString(3, task.getDescription());
        st.setString(4, String.valueOf(task.getStatus()));
        st.setString(5, String.valueOf(task.getPriority()));
        st.setDate(6, Date.valueOf(task.getDueDate()));
        st.setTimestamp(7, Timestamp.valueOf(task.getCreatedAt()));
    }

    private void rebuild(ResultSet result) throws SQLException {
        builder.setId( (UUID) result.getObject("id"));
        builder.setNameTask(result.getString("nametask"));
        builder.setDescription(result.getString("description"));
        builder.setStatus(Status.valueOf(result.getString("status")));
        builder.setPriority(Priority.valueOf(result.getString("priority")));
        builder.setDueDate(result.getDate("duedate").toLocalDate());
        builder.setCreatedAt(result.getTimestamp("createdat").toLocalDateTime());
    }
}
