package com.tutuncu.abdullah.loanApp.controller;

import com.tutuncu.abdullah.loanApp.model.Customer;
import com.tutuncu.abdullah.loanApp.model.Loan;
import com.tutuncu.abdullah.loanApp.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }


    @PostMapping("/add")
    public ResponseEntity<Loan> addLoan(@Validated @RequestBody Loan loan) {
        return new ResponseEntity<Loan>(loanService.addLoan(loan), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable long id, @Validated @RequestBody Loan loan) {
        loan.setId(id);
        return new ResponseEntity<Loan>(loanService.updateLoan(loan), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLoan(@PathVariable long id) {
        loanService.deleteLoan(id);
    }

    @GetMapping("/getLoan/{id}")
    public Optional<Loan> getLoan(@PathVariable long id) {
        return loanService.getLoan(id);
    }

    @GetMapping("/getAll")
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }
}
