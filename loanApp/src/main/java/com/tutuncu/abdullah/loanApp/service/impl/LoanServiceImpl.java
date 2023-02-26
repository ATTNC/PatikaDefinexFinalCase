package com.tutuncu.abdullah.loanApp.service.impl;

import com.tutuncu.abdullah.loanApp.model.Loan;
import com.tutuncu.abdullah.loanApp.repository.LoanRepository;
import com.tutuncu.abdullah.loanApp.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class LoanServiceImpl implements LoanService {

    private LoanRepository loanRepository;
    private final Logger logger = LoggerFactory.getLogger(LoanServiceImpl.class);

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan addLoan(Loan loan) {
        logger.info("Loan added id: {} loan type: {}", loan.getId(), loan.getLoanType());
        return loanRepository.save(loan);
    }

    @Override
    public Loan updateLoan(Loan loan) {
        logger.info("Loan updated id: {}",loan.getId());
        return loanRepository.save(loan);
    }

    @Override
    public void deleteLoan(long id) {
        logger.info("Loan deleted id: {}",id);
        loanRepository.deleteById(id);
    }

    @Override
    public Optional<Loan> getLoan(long id) {
        logger.info("Loan selected id: {}",id);
        return loanRepository.findById(id);
    }

    @Override
    public List<Loan> getAllLoans() {
       logger.info("All Loans listed");
        return loanRepository.findAll();
    }
}
