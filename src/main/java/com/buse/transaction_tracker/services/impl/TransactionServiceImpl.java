package com.buse.transaction_tracker.services.impl;

import com.buse.transaction_tracker.model.Transaction;
import com.buse.transaction_tracker.repository.TransactionRepository;
import com.buse.transaction_tracker.services.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactionRepository.addTransaction(transaction);
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionRepository.getAllTransactions();
    }
}
