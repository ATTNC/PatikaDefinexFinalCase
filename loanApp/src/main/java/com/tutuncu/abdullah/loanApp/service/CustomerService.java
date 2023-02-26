package com.tutuncu.abdullah.loanApp.service;

import com.tutuncu.abdullah.loanApp.model.Customer;
import com.tutuncu.abdullah.loanApp.model.LoginResponse;

import java.util.List;
import java.util.Optional;


public interface CustomerService {

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void deleteCustomer(long id);

    Optional<Customer> getCustomer(long id);

    List<Customer> getAllCustomers();

    LoginResponse login(String identityNumber, String password);


}
