package com.simplecashier.repository;

import com.simplecashier.db.DatabaseConnection;
import com.simplecashier.model.Transaction;
import com.simplecashier.model.TransactionType;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Transaction> findAll() throws SQLException {
        String sql = "SELECT * FROM transactions";
        List<Transaction> transactions = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Transaction t = Transaction.builder()
                        .id(rs.getLong("id"))
                        .description(rs.getString("description"))
                        .amount(new BigDecimal(rs.getString("amount")))
                        .type(TransactionType.valueOf(rs.getString("type")))
                        .category(rs.getString("category"))
                        .date(LocalDate.parse(rs.getString("date")))
                        .build();
                transactions.add(t);
            }
        }
        return transactions;
    }
}
