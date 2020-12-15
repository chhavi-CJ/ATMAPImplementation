package com.demo.atmAPI.service;

public interface Operations {

	double checkBalance(String accountNumber);

	boolean withdraw(String accountNumber, Double amount);

	boolean deposit(String accountNumber, Double amount);

}
