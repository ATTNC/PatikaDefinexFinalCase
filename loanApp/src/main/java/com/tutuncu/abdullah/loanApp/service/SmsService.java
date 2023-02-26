package com.tutuncu.abdullah.loanApp.service;

import com.twilio.rest.api.v2010.account.Message;

public interface SmsService {

    public Message sendSmsTrue(String identityNumber);
    public Message sendSmsFalse(String identityNumber);
}
