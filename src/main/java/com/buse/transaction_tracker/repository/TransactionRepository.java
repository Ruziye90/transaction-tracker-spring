package com.buse.transaction_tracker.repository;


import com.buse.transaction_tracker.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {

    public static ArrayList<Transaction> transactionArrayList = new ArrayList<>();
    public List<Transaction> getAllTransactions() {
        return transactionArrayList;
    }

    public void addTransaction(Transaction transaction) {
        transactionArrayList.add(transaction);
    }
}
