package com.tutuncu.abdullah.loanApp.repository;

import com.tutuncu.abdullah.loanApp.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface LoanRepository extends JpaRepository<Loan,Long> {

}
