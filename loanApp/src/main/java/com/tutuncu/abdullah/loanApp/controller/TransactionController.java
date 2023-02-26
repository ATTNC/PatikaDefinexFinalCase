package com.tutuncu.abdullah.loanApp.controller;

import com.tutuncu.abdullah.loanApp.model.*;
import com.tutuncu.abdullah.loanApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/result")
    public TransactionResponse checkCustomerIdentity(@Validated @RequestBody TransactionRequest transactionRequest) {
        return transactionService.transactionResult(transactionRequest.getIdentityNumber(), transactionRequest.getLoanType());
    }

    @GetMapping("/getTransaction/{id}")
    public Optional<TransactionResponse> getTransaction(@PathVariable long id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping("/getAll")
    public List<TransactionResponse> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable long id) {
        transactionService.deleteTransaction(id);
    }

}
