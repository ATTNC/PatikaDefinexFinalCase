package com.tutuncu.abdullah.loanApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Firstname cannot be null")
    private String firstName;
    @NotBlank(message = "Lastname cannot be null")
    private String lastName;
    @Column(name = "identity_number")
    @NotBlank(message = "Identity number cannot be null")
    private String identityNumber;
    @NotBlank(message = "Phone number cannot be null")
    private String phoneNumber;
    private int monthlyIncome;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank(message = "Date of birth cannot be null")
    private String dateOfBirth;
    @Column(name = "password")
    @NotBlank(message = "Password cannot be null")
    private String password;
    private int guarantee;
    private int loanScore;


}
