package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.AccountTransfer;
import com.revature.model.BankCustomer;
import com.revature.model.BankEmployee;
import com.revature.model.CustomerAccount;
import com.revature.model.Transaction;
import com.revature.model.User;
import com.revature.repo.BankDatabase;

public class DAOBankService implements BankService {
	BankDatabase bankDatabase;
	
	public DAOBankService(BankDatabase bankdatabase) {
		this.bankDatabase = bankdatabase;
	}

	@Override
	public boolean MakeCustomerAccount(BankCustomer bankcustomer) {
		// TODO Auto-generated method stub
		
		return this.bankDatabase.insertCustomer(bankcustomer);
		
//		System.out.println("Added to the customer database");
	}

	

	@Override
	public BankCustomer loginCustomer(User user) {
		
		//int loggedIn =0;
		
		//loggedIn = this.bankDatabase.selectCustomerUser(user, customerLoggedIn);
		// TODO Auto-generated method stub
		return this.bankDatabase.selectCustomerUser(user);
	}

	@Override
	public ArrayList<CustomerAccount> getAllAccountsOfCustomer(BankCustomer customerLoggedIn) {
		// TODO Auto-generated method stub
			//this.bankDatabase.selectAllAccountsOfCustomer(customerLoggedIn);
		
		return this.bankDatabase.selectAllAccountsOfCustomer(customerLoggedIn);
	}

	@Override
	public boolean MakeDeposit(double amount, int accountNumber) {
		// TODO Auto-generated method stub
		return this.bankDatabase.updateCustomerAccount(amount, accountNumber);
	}

	@Override
	public boolean MakeWithdrawal(int accountNumber, double amount) {
		// TODO Auto-generated method stub
	
		return this.bankDatabase.updateCustomerAccount(amount, accountNumber);
	}

	@Override
	public void MakeNewCustomerAccount(CustomerAccount customerAccount, int customerNumber) {
		// TODO Auto-generated method stub
		this.bankDatabase.insertCustomerAccount(customerAccount, customerNumber);
	}

	@Override
	public BankEmployee loginEmployee(User user) {
		// TODO Auto-generated method stub
		
		return this.bankDatabase.selectEmployeeUser(user);
	}

	@Override
	public boolean MakeEmployeeAccount(BankEmployee bankemployee) {
		// TODO Auto-generated method stub
		
		return this.bankDatabase.insertEmployee(bankemployee);
		
		//System.out.println("Added to the employee database");
		
	}

	@Override
	public ArrayList<CustomerAccount> getAllCustomerAccounts() {
		// TODO Auto-generated method stub
		return this.bankDatabase.selectAllCustomerAccounts();
	}

	@Override
	public boolean approveCustomerAccount(int accountNumber) {
		// TODO Auto-generated method stub
		return this.bankDatabase.updateApproveCustomerAccount(accountNumber);
		
	}

	@Override
	public boolean removeCustomerAccount(int accountNumber) {
		// TODO Auto-generated method stub
		return this.bankDatabase.deleteCustomerAccount(accountNumber);
	}

	@Override
	public void MakeTransfer(AccountTransfer accountTransfer) {
		// TODO Auto-generated method stub
		this.bankDatabase.InsertTransferAccount(accountTransfer);
	}

	@Override
	public ArrayList<AccountTransfer> getAllCustomerAccountTransfers(BankCustomer customerLoggedIn) {
		// TODO Auto-generated method stub
		
		return this.bankDatabase.selectAllAccountTransfersOfCustomer(customerLoggedIn);
		
	}

	@Override
	public boolean removeAccountTransfer(int transferAccountNumber) {
		// TODO Auto-generated method stub
		return this.bankDatabase.deleteAccountTransfer(transferAccountNumber);
	}

	@Override
	public void addTransAction(Transaction transaction) {
		// TODO Auto-generated method stub
		this.bankDatabase.insertTransAction(transaction);
	}

	@Override
	public ArrayList<Transaction> getAllTransActions() {
		// TODO Auto-generated method stub
		return this.bankDatabase.selectAllTransActions();
	}


	
}
