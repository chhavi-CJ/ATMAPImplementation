package com.demo.atmAPI.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.demo.atmAPI.account.repository.AccountRepositoryImpl;
import com.demo.atmAPI.model.Account;

public class AuthenticationServiceImpl implements AuthenticationService {
	private AccountRepositoryImpl accountRepository = null;
	private static Map<String, String> authDetails = new HashMap<String, String>();

  
	@Override
	public String generateToken(Account account) {
		System.out.println("hiiii");
		accountRepository = new AccountRepositoryImpl();
		boolean result = accountRepository.verifyAccount(account);
	        if (result == true) {
	        	String token = UUID.randomUUID().toString();
	        	String tokenwithtimestamp = token+ ":" + System.currentTimeMillis();
	        	String[] t = tokenwithtimestamp.split(":");
	        	String token_time = t[1];
	        	System.out.println("tokentime-"+token_time);
	            authDetails.put(new String(account.getaccount_number()), token);
	            return token;
	        } else {
	            return "Invalid Account or PIN";
	        }
	}

	@Override
	public boolean verifyToken(String accountNumber, String token) {
		String existingToken = authDetails.get(new String(accountNumber));
System.out.println(existingToken);
        if (existingToken != null && existingToken.equals(token)) {
            authDetails.remove(new Long(accountNumber));
            return true;
        } else {
            return false;
        }
	}

}
