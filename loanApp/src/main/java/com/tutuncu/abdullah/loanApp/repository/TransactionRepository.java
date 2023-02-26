package com.tutuncu.abdullah.loanApp.repository;

import com.tutuncu.abdullah.loanApp.model.TransactionResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<TransactionResponse,Long> {


}
