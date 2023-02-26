package com.tutuncu.abdullah.loanApp.service;

import com.tutuncu.abdullah.loanApp.model.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanService {


    Loan addLoan(Loan loan);

    Loan updateLoan(Loan loan);

    void deleteLoan(long id);
    Optional<Loan> getLoan(long id);
    List<Loan> getAllLoans();



}
