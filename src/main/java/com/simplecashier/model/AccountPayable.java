package com.simplecashier.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Builder
public class AccountPayable {
    private Long id;
    private String description;
    private BigDecimal amount;
    private Status status;
    private LocalDate dueDate;
    private LocalDate paymentDate;

}
