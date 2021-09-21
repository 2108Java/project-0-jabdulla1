package com.revature.model;

public class CustomerAccount {

	int id;
	int accountNumber;
	String typeOfAccount;
	double balance;
	boolean isapproved;
	int foreign_customer_key;
	
	
	public CustomerAccount(int id, int accountNumber, String typeOfAccount, double balance,
			int foreign_customer_key,  boolean isapproved) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.typeOfAccount = typeOfAccount;
		this.balance = balance;
		this.isapproved = isapproved;
		this.foreign_customer_key = foreign_customer_key;
	}
	
	
	@Override
	public String toString() {
		return "\nCustomerAccount---- \n Account Number: " + accountNumber + "\n Type Of Account: " + typeOfAccount
				+ "\n Balance: " + balance + "\n Is it Approved: " + isapproved;

		
	}
/*
	@Override
	public String toString() {
		return "CustomerAccount [id=" + id + ", accountNumber=" + accountNumber + ", typeOfAccount=" + typeOfAccount
				+ ", balance=" + balance + ", isapproved=" + isapproved + ", foreign_customer_key="
				+ foreign_customer_key + "]";
	}*/




	public CustomerAccount(int accountNumber, String typeOfAccount, double balance,
			int foreign_customer_key, boolean isapproved) {
		super();
		this.id =0;
		this.accountNumber = accountNumber;
		this.typeOfAccount = typeOfAccount;
		this.balance = balance;
		this.isapproved = isapproved;
		this.foreign_customer_key = foreign_customer_key;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getTypeOfAccount() {
		return typeOfAccount;
	}


	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public boolean isIsapproved() {
		return isapproved;
	}


	public void setIsapproved(boolean isapproved) {
		this.isapproved = isapproved;
	}


	public int getForeign_customer_key() {
		return foreign_customer_key;
	}


	public void setForeign_customer_key(int foreign_customer_key) {
		this.foreign_customer_key = foreign_customer_key;
	}
	
	
	
	
	
	
	
	
	
}
