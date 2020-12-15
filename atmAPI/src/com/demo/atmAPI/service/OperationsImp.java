package com.demo.atmAPI.service;

import com.demo.atmAPI.account.repository.AccountRepositoryImpl;

public class OperationsImp implements Operations {

	private AccountRepositoryImpl accountRepository = null;

	@Override
	public double checkBalance(String accountNumber) {
		accountRepository= new AccountRepositoryImpl();
		return  accountRepository.getBalance(accountNumber);
	}

	@Override
	public boolean withdraw(String accountNumber, Double amount) {
		accountRepository= new AccountRepositoryImpl();
		 double balance = accountRepository.getBalance(accountNumber);
	        if (balance >= amount) {
	            boolean result = accountRepository.withdraw(accountNumber, amount, balance);
	            if (result) {
	                return result;
	            } else {
	                return false;
	            }
	        } else {
	            throw new RuntimeException("There is not enough balance in your account.");
	        }
	}

	@Override
	public boolean deposit(String accountNumber, Double amount) {
		accountRepository= new AccountRepositoryImpl();
		 double balance = accountRepository.getBalance(accountNumber);
	        if (amount > 0) {
	            boolean result = accountRepository.deposit(accountNumber, amount, balance);
	            if (result) {
	                return result;
	            } else {
	                return false;
	            }
	        } else {
	            throw new RuntimeException("Please enter a valid ammount");
	        }
	}

}
