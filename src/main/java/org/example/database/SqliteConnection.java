package org.example.database;

import java.sql.*;

public class SqliteConnection {
    private static final String URL = "jdbc:sqlite:eventos.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
