package com.demo.atmAPI.service;

import com.demo.atmAPI.model.Account;

public interface AuthenticationService {

    String generateToken(Account account);

    boolean verifyToken(String accountNumber, String token);

}
