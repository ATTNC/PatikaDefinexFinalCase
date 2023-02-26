package com.tutuncu.abdullah.loanApp.service.impl;

import com.tutuncu.abdullah.loanApp.service.SmsService;
import com.tutuncu.abdullah.loanApp.model.*;
import com.tutuncu.abdullah.loanApp.repository.CustomerRepository;
import com.tutuncu.abdullah.loanApp.repository.TransactionRepository;
import com.tutuncu.abdullah.loanApp.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private CustomerRepository customerRepository;
    private TransactionRepository transactionRepository;
    private SmsService smsService;


    private final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    public TransactionServiceImpl(CustomerRepository customerRepository, TransactionRepository transactionRepository, SmsService smsService) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
        this.smsService = smsService;


    }

    @Override
    public TransactionResponse transactionResult(String identityNumber, String loanType) {

        Customer customerIdentity = customerRepository.findByIdentityNumber(identityNumber);
        int customerMonthlyIncome = customerRepository.findMonthlyIncome(identityNumber);
        int customerLoanScore = customerRepository.findLoanScore(identityNumber);
        int customerGuarantee = customerRepository.findGuarantee(identityNumber);


        TransactionResponse transactionResponse = new TransactionResponse();


        if (customerIdentity != null && customerMonthlyIncome < 5000) {
            transactionResponse.setStatus("Transaction failed because poor credit score");
            transactionResponse.setLoanType(loanType);
            transactionResponse.setIdentityNumber(identityNumber);
            transactionResponse.setLoanLimit(0);
            logger.info("Transaction failed customer identity number: {}", identityNumber);
            smsService.sendSmsFalse(identityNumber);
            return transactionResponse;
        }
        if (customerIdentity != null && customerMonthlyIncome == 5000) {
            transactionResponse.setStatus("Success");
            transactionResponse.setLoanType(loanType);
            transactionResponse.setIdentityNumber(identityNumber);
            transactionResponse.setLoanLimit(10000);
            if (customerGuarantee > 0) {
                transactionResponse.setLoanLimit(10000 + ((customerGuarantee * 10) / 100));
            }
            transactionRepository.save(transactionResponse);
            logger.info("Transaction success customer identity number: {}", identityNumber);
            smsService.sendSmsTrue(identityNumber);
            return transactionResponse;
        }
        if (customerIdentity != null && customerMonthlyIncome > 5000 && customerMonthlyIncome < 10000) {
            transactionResponse.setStatus("Success");
            transactionResponse.setLoanType(loanType);
            transactionResponse.setIdentityNumber(identityNumber);
            transactionResponse.setLoanLimit(20000);
            if (customerGuarantee > 0) {
                transactionResponse.setLoanLimit(20000 + ((customerGuarantee * 20) / 100));
            }
            transactionRepository.save(transactionResponse);
            logger.info("Transaction success customer identity number: {}", identityNumber);
            smsService.sendSmsTrue(identityNumber);
            return transactionResponse;
        }

        if (customerIdentity != null && customerMonthlyIncome == 10000) {
            transactionResponse.setStatus("Success");
            transactionResponse.setLoanType(loanType);
            transactionResponse.setIdentityNumber(identityNumber);
            transactionResponse.setLoanLimit(customerMonthlyIncome * 2);
            if (customerGuarantee > 0) {
                transactionResponse.setLoanLimit(customerMonthlyIncome * 2 + ((customerGuarantee * 25) / 100));
            }
            transactionRepository.save(transactionResponse);
            logger.info("Transaction success customer identity number: {}", identityNumber);
            smsService.sendSmsTrue(identityNumber);
            return transactionResponse;
        }

        if (customerIdentity != null && customerMonthlyIncome > 10000) {
            transactionResponse.setStatus("Success");
            transactionResponse.setLoanType(loanType);
            transactionResponse.setIdentityNumber(identityNumber);
            transactionResponse.setLoanLimit(customerMonthlyIncome * 4);
            if (customerGuarantee > 0) {
                transactionResponse.setLoanLimit(customerMonthlyIncome * 4 + ((customerGuarantee * 50) / 100));
            }
            transactionRepository.save(transactionResponse);
            logger.info("Transaction success customer identity number: {}", identityNumber);
            smsService.sendSmsTrue(identityNumber);
            return transactionResponse;
        } else {
            transactionResponse.setStatus("Failed");
            logger.info("Transaction failed customer not found");
            return transactionResponse;
        }
    }

    @Override
    public List<TransactionResponse> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<TransactionResponse> getTransactionById(long id) {
        logger.info("Transaction selected id: {} ", id);
        return transactionRepository.findById(id);
    }

    @Override
    public void deleteTransaction(long id) {
        logger.info("Transaction deleted id: {} ", id);
        transactionRepository.deleteById(id);
    }
}
