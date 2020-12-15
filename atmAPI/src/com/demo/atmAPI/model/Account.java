package com.demo.atmAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
	private String account_number;
	private String name;
	private String ac_type;
	private Long card_num;
	private String unique_pin; 
	private Double balance;
	
	public String getaccount_number() {
		return account_number;
	}
	public void setaccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getac_type() {
		return ac_type;
	}
	public void setac_type(String ac_type) {
		this.ac_type = ac_type;
	}
	public Long getcard_num() {
		return card_num;
	}
	public void setcard_num(Long card_num) {
		this.card_num = card_num;
	}
	public String getunique_pin() {
		return unique_pin;
	}
	public void setunique_pin(String unique_pin) {
		this.unique_pin = unique_pin;
	}
	public Double getbalance() {
		return balance;
	}
	public void setbalance(Double balance) {
		this.balance = balance;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String account_number, String name, String ac_type, Long card_num, String unique_pin,
			Double balance) {
		super();
		this.account_number = account_number;
		this.name = name;
		this.ac_type = ac_type;
		this.card_num = card_num;
		this.unique_pin = unique_pin;
		this.balance = balance;
	}
}
