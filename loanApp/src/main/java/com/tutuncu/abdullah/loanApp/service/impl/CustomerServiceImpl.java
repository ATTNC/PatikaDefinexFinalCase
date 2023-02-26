package com.tutuncu.abdullah.loanApp.service.impl;

import com.tutuncu.abdullah.loanApp.model.Customer;
import com.tutuncu.abdullah.loanApp.model.Loan;
import com.tutuncu.abdullah.loanApp.model.LoginResponse;
import com.tutuncu.abdullah.loanApp.repository.CustomerRepository;
import com.tutuncu.abdullah.loanApp.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customer.setLoanScore(customer.getMonthlyIncome() / 10);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        logger.info("Customer updated id: {} ", customer.getId());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {
        logger.info("Customer deleted id: {} ", id);
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> getCustomer(long id) {
        logger.info("Customer selected id: {} ", id);
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        logger.info("All Customers listed ");
        return customerRepository.findAll();
    }

    @Override
    public LoginResponse login(String identityNumber, String password) {


        Customer customerId = customerRepository.findByIdentityNumberAndPassword(identityNumber, password);
        LoginResponse loginResponse = new LoginResponse();
        if (customerId != null) {
            logger.info("Customer logged in identity number: {} ", identityNumber);
            loginResponse.setMessage("Login success");
            return loginResponse;
        } else {
            logger.info("Login failed");
            loginResponse.setMessage("Login failed");
            return loginResponse;
        }


    }

}
