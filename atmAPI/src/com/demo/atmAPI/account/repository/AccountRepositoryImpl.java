package com.demo.atmAPI.account.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.atmAPI.model.Account;
import com.demo.atmAPI.db.connector.H2DatabaseClient;


public class AccountRepositoryImpl implements AccountRepository {
	private static List<String> accountlist = new  ArrayList<>();
	H2DatabaseClient databaseClient = new H2DatabaseClient();
	@Override
	public boolean addAccount(Account account) {
		System.out.println("hiinside insert");
		
		if(!(verifyAccount(account))){
		    try {
		      PreparedStatement ps = databaseClient.getPreparedStatement("INSERT INTO USERREPOSITORY  VALUES(?,?,?,?,?,?)");
		      ps.setString(1, account.getaccount_number());
		      ps.setString(2, account.getname());
		      ps.setString(3, account.getac_type());
		      ps.setLong(4, account.getcard_num());
		      ps.setString(5, account.getunique_pin());
		      ps.setDouble(6, account.getbalance());
		      int count=0;
		      synchronized(this){
		    	  count = ps.executeUpdate();
		      }
		      System.out.println("Event inserted: " + count);
		      return true;
		    } catch (Exception e) {
		      System.out.print("Unable to insert Event in db: " + e.getMessage());
		      e.printStackTrace();
		      return false;
		    }
		}
		else
			return false;
	}

	@Override
	public boolean verifyAccount(Account account) {
		//H2DatabaseClient databaseClient = new H2DatabaseClient();
		int count=0;
		System.out.println("verifyac");
		try{
		String account_number = account.getaccount_number();
		String ACCOUNT_NAME = account.getname();
		String pin = account.getunique_pin();
		String query = "Select count(*) as ACCOUNT_COUNT from USERREPOSITORY where"
		 		+ " ACCOUNTNO="+"'"+account_number+"'"+" AND"
		 				+ " NAME="+"'"+ACCOUNT_NAME+"'"
		 				+ " AND PIN="+"'"+pin+"'"+"";
		System.out.println(query);
		ResultSet resultSet = null;
		synchronized ( this.databaseClient){
			resultSet = databaseClient.executeSelect(query);	
		}
		System.out.println(resultSet);
		 if (resultSet.next()) {
		count = resultSet.getInt("ACCOUNT_COUNT");
		 }
		System.out.println(count);
		if(count==1)
			return true;
		else 
			return false;
		} catch (Exception e) {
		      System.out.print("Unable to fetch data in db: " + e.getMessage());
		      e.printStackTrace();
		      return false;
		    }
	}

	@Override
	public double getBalance(String accountNumber) {
		//H2DatabaseClient databaseClient = new H2DatabaseClient();
		String querry = "select BALANCE from USERREPOSITORY where ACCOUNTNO="+"'"+accountNumber+"'"+"";
		Double Balance = 0.0;
	    try {
	    	ResultSet resultSet = null;
	    	synchronized ( this.databaseClient){
	    	resultSet = databaseClient.executeSelect(querry);	
	    	}	
	    	while (resultSet.next()) {
	    		Balance = resultSet.getDouble("BALANCE");
	    		 }
	    }catch (Exception e) {
		      System.out.print("Unable to fetch data from db: " + e.getMessage());
		      e.printStackTrace();
		      return 0;
		    }
		
		return Balance;
	}

	@Override
	public boolean withdraw(String accountNumber, Double amount , Double balance) {
		//H2DatabaseClient databaseClient = new H2DatabaseClient();
		try {
	      PreparedStatement ps = databaseClient.getPreparedStatement("update USERREPOSITORY set BALANCE =? where ACCOUNTNO=?");
	      balance = balance - amount;
	      ps.setDouble(1, balance);
	      ps.setString(2, accountNumber);
	      int count = 0;
	      synchronized(this){
	    		count = ps.executeUpdate();
	      }
	    }catch (Exception e) {
		      System.out.print("Unable to fetch data from db: " + e.getMessage());
		      e.printStackTrace();
		      return false;
		    }
		
		return true;
	}

	@Override
	public boolean deposit(String accountNumber, Double amount, Double balance) {
		//H2DatabaseClient databaseClient = new H2DatabaseClient();
		try {
	      PreparedStatement ps = databaseClient.getPreparedStatement("update USERREPOSITORY set BALANCE =? where ACCOUNTNO=?");
	      balance = balance + amount;
	      ps.setDouble(1, balance);
	      ps.setString(2, accountNumber);
	      int count = 0;
	      synchronized(this){
	      count = ps.executeUpdate();
	      }
	    }catch (Exception e) {
		      System.out.print("Unable to fetch data from db: " + e.getMessage());
		      e.printStackTrace();
		      return false;
		    }
		
		return true;
	}


}
