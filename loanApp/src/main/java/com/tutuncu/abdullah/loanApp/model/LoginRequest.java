package com.tutuncu.abdullah.loanApp.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Identity number cannot be null")
    private String identityNumber;
    @NotBlank(message = "Password cannot be null")
    private String password;




}
