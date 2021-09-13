package com.revature.service;

import com.revature.model.BankCustomer;
import com.revature.model.CustomerAccount;
import com.revature.model.User;
import com.revature.repo.BankDatabase;

public class DAOBankService implements BankService {
	BankDatabase bankDatabase;
	
	public DAOBankService(BankDatabase bankdatabase) {
		this.bankDatabase = bankdatabase;
	}

	@Override
	public void MakeCustomerAccount(BankCustomer bankcustomer) {
		// TODO Auto-generated method stub
		
		this.bankDatabase.insertCustomer(bankcustomer);
		
		System.out.println("Added to the customer database");
	}

	

	@Override
	public BankCustomer loginCustomer(User user) {
		
		int loggedIn =0;
		
		//loggedIn = this.bankDatabase.selectCustomerUser(user, customerLoggedIn);
		// TODO Auto-generated method stub
		return this.bankDatabase.selectCustomerUser(user);
	}

	@Override
	public CustomerAccount[] getAllAccountsOfCustomer(BankCustomer customerLoggedIn) {
		// TODO Auto-generated method stub
			//this.bankDatabase.selectAllAccountsOfCustomer(customerLoggedIn);
		
		return this.bankDatabase.selectAllAccountsOfCustomer(customerLoggedIn);
	}

	@Override
	public void MakeDeposit(double amount, int accountNumber) {
		// TODO Auto-generated method stub
		this.bankDatabase.updateCustomerAccount(amount, accountNumber);
	}

	@Override
	public void MakeWithdrawal(int accountNumber, double amount) {
		// TODO Auto-generated method stub
	
		this.bankDatabase.updateCustomerAccount(amount, accountNumber);
	}

	
}
