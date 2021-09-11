package com.revature.service;

import com.revature.model.BankCustomer;
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
	
}
