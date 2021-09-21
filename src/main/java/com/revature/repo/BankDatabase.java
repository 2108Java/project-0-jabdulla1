package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.AccountTransfer;
import com.revature.model.BankCustomer;
import com.revature.model.BankEmployee;
import com.revature.model.CustomerAccount;
import com.revature.model.Transaction;
import com.revature.model.User;

public interface BankDatabase {

	boolean insertCustomer(BankCustomer bankcustomer);

	//int selectCustomerUser(BankCustomer customerLoggedIn);

	//CustomerAccount[] selectAllAccountsOfCustomer(BankCustomer customerLoggedIn);
	ArrayList<CustomerAccount> selectAllAccountsOfCustomer(BankCustomer customerLoggedIn);

	//int selectCustomerUser(User user, BankCustomer customerLoggedIn);

	BankCustomer selectCustomerUser(User user);

	//void updateCustomerAccount(CustomerAccount[] customerAccounts, double amount, int accountNumber);

	boolean updateCustomerAccount(double amount, int accountNumber);

	void insertCustomerAccount(CustomerAccount customerAccount, int customerNumber);

	BankEmployee selectEmployeeUser(User user);

	boolean insertEmployee(BankEmployee bankemployee);

	ArrayList<CustomerAccount> selectAllCustomerAccounts();

	boolean updateApproveCustomerAccount(int accountNumber);

	boolean deleteCustomerAccount(int accountNumber);

	void InsertTransferAccount(AccountTransfer accountTransfer);

	//AccountTransfer[] selectAllAccountTransfersOfCustomer(BankCustomer customerLoggedIn);
	ArrayList<AccountTransfer> selectAllAccountTransfersOfCustomer(BankCustomer customerLoggedIn);

	boolean deleteAccountTransfer(int transferAccountNumber);

	void insertTransAction(Transaction transaction);

	//Transaction[] selectAllTransActions();
	ArrayList<Transaction> selectAllTransActions();

}
