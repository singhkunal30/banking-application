package com.banking.accounts.service;

import com.banking.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService {

    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
