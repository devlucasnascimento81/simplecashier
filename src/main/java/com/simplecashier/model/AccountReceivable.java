package com.simplecashier.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Builder
public class AccountReceivable {
    private Long id;
    private String description;
    private BigDecimal amount;
    private ReceivableStatus status;
    private LocalDate dueDate;
    private LocalDate receivedDate;

}
