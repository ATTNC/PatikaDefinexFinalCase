package com.tutuncu.abdullah.loanApp.service;

import com.tutuncu.abdullah.loanApp.model.TransactionResponse;

import java.util.List;
import java.util.Optional;

public interface TransactionService {


   TransactionResponse transactionResult(String identityNumber,String loanType);

   List<TransactionResponse> getAllTransactions();

   Optional<TransactionResponse> getTransactionById(long id);

   void deleteTransaction(long id);

}
