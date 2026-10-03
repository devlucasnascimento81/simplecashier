package com.simplecashier.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL =  "jdbc:sqlite:simplecashier.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initializeSchema() {
        String sql = null;

        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("schema.sql")) {
            byte[] bytes = input.readAllBytes();
            sql = new String(bytes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (Connection conn = getConnection() ;
             Statement stmt = conn.createStatement()  ) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}


