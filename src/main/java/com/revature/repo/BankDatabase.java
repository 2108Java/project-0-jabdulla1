package com.revature.repo;

import com.revature.model.BankCustomer;
import com.revature.model.CustomerAccount;
import com.revature.model.User;

public interface BankDatabase {

	void insertCustomer(BankCustomer bankcustomer);

	//int selectCustomerUser(BankCustomer customerLoggedIn);

	CustomerAccount[] selectAllAccountsOfCustomer(BankCustomer customerLoggedIn);

	//int selectCustomerUser(User user, BankCustomer customerLoggedIn);

	BankCustomer selectCustomerUser(User user);

	//void updateCustomerAccount(CustomerAccount[] customerAccounts, double amount, int accountNumber);

	void updateCustomerAccount(double amount, int accountNumber);

}
