package com.buse.transaction_tracker.services;

import com.buse.transaction_tracker.model.Transaction;

import java.util.List;

public interface TransactionService {
    void addTransaction(Transaction transaction);
    List<Transaction> getTransactions();
}
