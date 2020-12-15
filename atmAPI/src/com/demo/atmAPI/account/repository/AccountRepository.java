package com.demo.atmAPI.account.repository;

import com.demo.atmAPI.model.Account;

public interface AccountRepository {

	double getBalance(String accountNumber);

	boolean withdraw(String accountNumber, Double amount , Double balance);

	boolean deposit(String accountNumber, Double amount , Double balance);

    boolean verifyAccount(Account account);
    
    boolean addAccount(Account account);


}
