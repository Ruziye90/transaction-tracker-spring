package com.buse.transaction_tracker.initialiser;


import com.buse.transaction_tracker.model.Transaction;
import com.buse.transaction_tracker.repository.TransactionRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;


@Component
public class TransactionInitializer implements ApplicationRunner {
    private final TransactionRepository transactionRepository;

    public TransactionInitializer(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        LocalDate localDate = LocalDate.now();

        Transaction dummyTransaction1 = new Transaction(
                localDate, BigDecimal.valueOf(3.56), "First dummy transaction"
        );
        Transaction dummyTransaction2 = new Transaction(
                localDate.minusDays(1), BigDecimal.valueOf(7.6), "Second dummy transaction"
        );
        Transaction dummyTransaction3 = new Transaction(
                localDate.minusDays(2), BigDecimal.valueOf(76.0), "Third dummy transaction"
        );
        transactionRepository.addTransaction(dummyTransaction1);
        transactionRepository.addTransaction(dummyTransaction2);
        transactionRepository.addTransaction(dummyTransaction3);

    }
}

