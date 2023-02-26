package com.tutuncu.abdullah.loanApp.service.impl;

import com.tutuncu.abdullah.loanApp.repository.CustomerRepository;
import com.tutuncu.abdullah.loanApp.repository.TransactionRepository;
import com.tutuncu.abdullah.loanApp.service.SmsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceTwilio implements SmsService {
    private final CustomerRepository customerRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public SmsServiceTwilio(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    public static final String ACCOUNT_SID = "Your Account Sıd";
    public static final String AUTH_TOKEN = "Your Auth Token";


    @Override
    public Message sendSmsTrue(String identityNumber) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String customerIdentity = customerRepository.smsIdentity(identityNumber);
        String customerPhoneNumber=customerRepository.findCustomerPhoneNumber(identityNumber);


        Message message = Message.creator(
                        new PhoneNumber(customerPhoneNumber), // sending phone number
                        new PhoneNumber(""),  // Twilio phone number
                        "Your loan application success Customer identity: " + customerIdentity)
                .create();

        return message;
    }

    @Override
    public Message sendSmsFalse(String identityNumber) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String customerIdentity = customerRepository.smsIdentity(identityNumber);
        String customerPhoneNumber = customerRepository.findCustomerPhoneNumber(identityNumber);


        Message message = Message.creator(
                        new PhoneNumber(customerPhoneNumber), // sending phone number
                        new PhoneNumber(""),  // Twilio phone number
                        "Your loan application not accepted Customer identity: " + customerIdentity)
                .create();

        return message;
    }
}
