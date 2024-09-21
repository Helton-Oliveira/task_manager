package com.example.taskMaster.adapter.repository;

import java.sql.PreparedStatement;

public interface IConnection {
    PreparedStatement query(String sql);
    void close();
}
