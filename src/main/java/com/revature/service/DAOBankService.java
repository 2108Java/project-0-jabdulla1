package com.revature.service;

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
	public void MakeCustomerAccount(BankCustomer bankcustomer) {
		// TODO Auto-generated method stub
		
		this.bankDatabase.insertCustomer(bankcustomer);
		
		System.out.println("Added to the customer database");
	}

	

	@Override
	public BankCustomer loginCustomer(User user) {
		
		//int loggedIn =0;
		
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
	public void MakeEmployeeAccount(BankEmployee bankemployee) {
		// TODO Auto-generated method stub
		
		this.bankDatabase.insertEmployee(bankemployee);
		
		System.out.println("Added to the employee database");
		
	}

	@Override
	public CustomerAccount[] getAllCustomerAccounts() {
		// TODO Auto-generated method stub
		return this.bankDatabase.selectAllCustomerAccounts();
	}

	@Override
	public void approveCustomerAccount(int accountNumber) {
		// TODO Auto-generated method stub
		this.bankDatabase.updateApproveCustomerAccount(accountNumber);
		
	}

	@Override
	public void removeCustomerAccount(int accountNumber) {
		// TODO Auto-generated method stub
		this.bankDatabase.deleteCustomerAccount(accountNumber);
	}

	@Override
	public void MakeTransfer(AccountTransfer accountTransfer) {
		// TODO Auto-generated method stub
		this.bankDatabase.InsertTransferAccount(accountTransfer);
	}

	@Override
	public AccountTransfer[] getAllCustomerAccountTransfers(BankCustomer customerLoggedIn) {
		// TODO Auto-generated method stub
		
		return this.bankDatabase.selectAllAccountTransfersOfCustomer(customerLoggedIn);
		
	}

	@Override
	public void removeAccountTransfer(int transferAccountNumber) {
		// TODO Auto-generated method stub
		this.bankDatabase.deleteAccountTransfer(transferAccountNumber);
	}

	@Override
	public void addTransAction(Transaction transaction) {
		// TODO Auto-generated method stub
		this.bankDatabase.insertTransAction(transaction);
	}

	@Override
	public Transaction[] getAllTransActions() {
		// TODO Auto-generated method stub
		return this.bankDatabase.selectAllTransActions();
	}


	
}
