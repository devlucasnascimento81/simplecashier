package com.simplecashier.repository;

import com.simplecashier.db.DatabaseConnection;
import com.simplecashier.model.Transaction;

import java.sql.*;

public class TransactionRepository {
    public Long save(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transactions (description, amount, type, category, date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, transaction.getDescription());
            stmt.setString(2, transaction.getAmount().toString());
            stmt.setString(3, transaction.getType().name());
            stmt.setString(4, transaction.getCategory());
            stmt.setString(5, transaction.getDate().toString());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
            return null;
        }
    }
}
