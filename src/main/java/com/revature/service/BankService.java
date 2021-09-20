package com.revature.service;

import com.revature.model.AccountTransfer;
import com.revature.model.BankCustomer;
import com.revature.model.BankEmployee;
import com.revature.model.CustomerAccount;
import com.revature.model.Transaction;
import com.revature.model.User;

public interface BankService {

	boolean MakeCustomerAccount(BankCustomer bankcustomer);


	//int loginCustomer(BankCustomer customerLoggedIn);


	CustomerAccount[] getAllAccountsOfCustomer(BankCustomer customerLoggedIn);


	//int loginCustomer(User user, BankCustomer customerLoggedIn);


	//int loginCustomer(User user, BankCustomer customerLoggedIn);


	BankCustomer loginCustomer(User user);

	

	//void MakeDeposit(CustomerAccount[] customerAccounts, double amount, int accountNumber);


	boolean MakeDeposit(double amount, int accountNumber);


	boolean MakeWithdrawal(int accountNumber, double amount);


	void MakeNewCustomerAccount(CustomerAccount customerAccount, int customerNumber);


	BankEmployee loginEmployee(User user);


	boolean MakeEmployeeAccount(BankEmployee bankemployee);


	CustomerAccount[] getAllCustomerAccounts();


	boolean approveCustomerAccount(int accountNumber);


	boolean removeCustomerAccount(int accountNumber);


	void MakeTransfer(AccountTransfer accountTransfer);


	AccountTransfer[] getAllCustomerAccountTransfers(BankCustomer customerLoggedIn);


	boolean removeAccountTransfer(int transferAccountNumber);


	void addTransAction(Transaction transAction);


	Transaction[] getAllTransActions();




}
