package com.simplecashier.repository;

import com.simplecashier.model.Transaction;
import com.simplecashier.model.TransactionType;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class repositoryTest {
    public static void main(String[] args) throws SQLException {
        TransactionRepository repo = new TransactionRepository();

        Transaction t = Transaction.builder()
                .description("Test sale")
                .amount(new BigDecimal("150.00"))
                .type(TransactionType.INCOME)
                .category("Sales")
                .date(LocalDate.now())
                .build();

        Long id = repo.save(t);
        System.out.println("Saved with id: " + id);

        List<Transaction> all = repo.findAll();
        all.forEach(System.out::println);
    }
}