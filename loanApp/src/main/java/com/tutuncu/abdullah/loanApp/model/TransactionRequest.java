package com.tutuncu.abdullah.loanApp.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
public class TransactionRequest {

    @NotBlank(message = "Identity number cannot be null")
    private String identityNumber;
    @NotBlank(message = "Loan type cannot be null")
    private String loanType;

}
