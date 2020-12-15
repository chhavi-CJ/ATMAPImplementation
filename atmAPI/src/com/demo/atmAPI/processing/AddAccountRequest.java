package com.demo.atmAPI.processing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.demo.atmAPI.account.repository.AccountRepositoryImpl;
import com.demo.atmAPI.model.Account;

public class AddAccountRequest {

    private AccountRepositoryImpl accountRepository = null;

	public Boolean addAccountReq(Account account) {
		accountRepository = new AccountRepositoryImpl();
		Boolean result = accountRepository.addAccount(account);
		return result;		
	}

	public void ConExecuterClass() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);

		executorService.execute(new Runnable() {
		    public void run() {
		        System.out.println("Asynchronous task");
		    }
		});

		executorService.shutdown();
		
	}
}
