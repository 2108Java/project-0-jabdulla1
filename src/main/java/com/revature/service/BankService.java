package com.revature.service;

import com.revature.model.BankCustomer;
import com.revature.model.BankEmployee;
import com.revature.model.CustomerAccount;
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




}
