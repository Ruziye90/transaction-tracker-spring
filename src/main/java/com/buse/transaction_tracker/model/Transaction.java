package com.buse.transaction_tracker.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    LocalDate date;
    BigDecimal amount;
    String description;

    public Transaction(LocalDate date, BigDecimal amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
