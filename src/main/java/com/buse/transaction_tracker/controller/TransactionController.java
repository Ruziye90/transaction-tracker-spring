package com.buse.transaction_tracker.controller;

import com.buse.transaction_tracker.model.Transaction;
import com.buse.transaction_tracker.services.impl.TransactionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

    private final TransactionServiceImpl transactionService;

    public TransactionController(TransactionServiceImpl transactionService) {
        this.transactionService = transactionService;
    }

    @Operation(summary ="Add a transaction")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Transaction successful"),
            @ApiResponse(responseCode = "208", description = "Transaction failed"),
    })
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addTransaction(@RequestBody Transaction transaction) {
        try {
            transactionService.addTransaction(transaction);
            return new ResponseEntity<>("Transaction has been added successfully", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Failed to create transaction", HttpStatus.valueOf(208));
        }
    }

    @Operation(summary ="Get list transaction")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login successful"),
            @ApiResponse(responseCode = "208", description = "Log in failed"),
    })
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> postTransaction() {
        try {
            return new ResponseEntity<>(transactionService.getTransactions(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.valueOf(208));
        }
    }
}
