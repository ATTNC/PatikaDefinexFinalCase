package com.tutuncu.abdullah.loanApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "transaction")
public class TransactionResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String status;
    private int loanLimit;
    private String loanType;
    private String identityNumber;



}
