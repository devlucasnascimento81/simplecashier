package com.simplecashier.repository;

import com.simplecashier.model.Transaction;
import com.simplecashier.model.TransactionType;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class test {
    public static void main(String[] args) throws SQLException {
        Transaction t = Transaction.builder()
                .description("Test sale")
                .amount(new BigDecimal("150.00"))
                .type(TransactionType.INCOME)
                .category("Sales")
                .date(LocalDate.now())
                .build();

        TransactionRepository repo = new TransactionRepository();
        Long id = repo.save(t);
        System.out.println("Saved with id: " + id);
    }
}
