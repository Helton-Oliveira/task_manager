package com.example.taskMaster.infra.repository;

import com.example.taskMaster.adapter.repository.IConnection;
import com.example.taskMaster.application.domain.components.Priority;
import com.example.taskMaster.application.domain.components.Status;
import com.example.taskMaster.application.domain.entities.Task;
import com.example.taskMaster.application.domain.entities.abstractions.RebuildTask;
import com.example.taskMaster.application.domain.entities.abstractions.RebuildTaskImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepositoryDatabase implements IRepository {

    private final IConnection connection;

    public TaskRepositoryDatabase(IConnection connection) {
        this.connection = connection;
    }

    @Override
    public Boolean save(Task task) {

        try {
            var st = connection.query("INSERT INTO tasks (id, nametask, description, status, priority, duedate, createdat) VALUES (?, ?, ?, ?, ?, ?, ?)");
            st.setObject(1, task.getId());
            st.setString(2, task.getNameTask());
            st.setString(3, task.getDescription());
            st.setString(4, String.valueOf(task.getStatus()));
            st.setString(5, String.valueOf(task.getPriority()));
            st.setDate(6, Date.valueOf(task.getDueDate()));
            st.setTimestamp(7, Timestamp.valueOf(task.getCreatedAt()));
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
    public Task get() {
        return null;
    }

    @Override
    public List<Task> getAll(RebuildTask rebuildTask) {
        List<Task> taskList = new ArrayList<>();

        try {
            var st = connection.query("SELECT * FROM tasks").executeQuery();
            while (st.next()) {
                taskList.add( rebuildTask.rebuild((UUID) st.getObject("id"),
                        st.getString("nametask"),
                        st.getString("description"),
                        Status.valueOf(st.getString("status")),
                        Priority.valueOf(st.getString("priority")),
                        st.getDate("duedate").toLocalDate(),
                        st.getTimestamp("createdat").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return taskList;
    }
}
