package com.tutuncu.abdullah.loanApp.controller;

import com.tutuncu.abdullah.loanApp.model.Customer;
import com.tutuncu.abdullah.loanApp.model.Loan;
import com.tutuncu.abdullah.loanApp.model.LoginRequest;
import com.tutuncu.abdullah.loanApp.model.LoginResponse;
import com.tutuncu.abdullah.loanApp.repository.CustomerRepository;
import com.tutuncu.abdullah.loanApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@Validated @RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @Validated @RequestBody Customer customer) {
        customer.setId(id);
        return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginCustomer(@RequestBody @Validated LoginRequest loginRequest) {
        return new ResponseEntity<LoginResponse>(customerService.login(loginRequest.getIdentityNumber(), loginRequest.getPassword()), HttpStatus.OK);
    }

    @GetMapping("/getCustomer/{id}")
    public Optional<Customer> getCustomer(@PathVariable long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }


}
