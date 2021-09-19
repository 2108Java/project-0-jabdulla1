package com.revature.service;

import com.revature.model.AccountTransfer;
import com.revature.model.BankCustomer;
import com.revature.model.BankEmployee;
import com.revature.model.CustomerAccount;
import com.revature.model.Transaction;
import com.revature.model.User;

public interface BankService {

	void MakeCustomerAccount(BankCustomer bankcustomer);


	//int loginCustomer(BankCustomer customerLoggedIn);


	CustomerAccount[] getAllAccountsOfCustomer(BankCustomer customerLoggedIn);


	//int loginCustomer(User user, BankCustomer customerLoggedIn);


	//int loginCustomer(User user, BankCustomer customerLoggedIn);


	BankCustomer loginCustomer(User user);


	//void MakeDeposit(CustomerAccount[] customerAccounts, double amount, int accountNumber);


	void MakeDeposit(double amount, int accountNumber);


	void MakeWithdrawal(int accountNumber, double amount);


	void MakeNewCustomerAccount(CustomerAccount customerAccount, int customerNumber);


	BankEmployee loginEmployee(User user);


	void MakeEmployeeAccount(BankEmployee bankemployee);


	CustomerAccount[] getAllCustomerAccounts();


	void approveCustomerAccount(int accountNumber);


	void removeCustomerAccount(int accountNumber);


	void MakeTransfer(AccountTransfer accountTransfer);


	AccountTransfer[] getAllCustomerAccountTransfers(BankCustomer customerLoggedIn);


	void removeAccountTransfer(int transferAccountNumber);


	void addTransAction(Transaction deposit);


	Transaction[] getAllTransActions();




}
