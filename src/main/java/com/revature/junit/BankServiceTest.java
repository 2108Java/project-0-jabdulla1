package com.revature.junit;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.revature.model.BankCustomer;
import com.revature.model.BankEmployee;
import com.revature.repo.BankDatabase;
import com.revature.repo.PostgreToDoDatabase;
import com.revature.service.BankService;
import com.revature.service.DAOBankService;

public class BankServiceTest {

	BankService bs;
	
	@Before
	public void setupCalculator() {
		System.out.println("Setting up a new BankService!");
		
		BankDatabase  BankPGDatabase = new PostgreToDoDatabase();
		
		bs= new DAOBankService(BankPGDatabase);
	
	}
	
	@Test //This is an annotation that tells the JVM that his is a testing method
	public void testDeposit() {
		
		assertTrue(bs.MakeDeposit(200, 11315));
	
	}
	
	@Test
	public void testWithdrawal() {
		
		assertTrue(bs.MakeWithdrawal(11315, 100));
	}
	
	@Test
	public void testApproveCustomerAccount(int accountNumber) {
		
		assertTrue(bs.approveCustomerAccount(11315));
	}
	
	@Test
	public void testRemoveCustomerAccount() {
		assertTrue(bs.removeCustomerAccount(204309));
	}
	
	@Test
	public void testRemoveAccountTransfer() {
		assertTrue(bs.removeAccountTransfer(20166609));
	}
	
	@Test
	public void testMakeCustomerAccount() {
		
		//BankCustomer ca = new BankCustomer();
		
		assertTrue(bs.MakeCustomerAccount(new BankCustomer(1, "good123", "good123", new Random().nextInt(100000), "goodman",
				"goodfamily")));
	}
	
	@Test
	public void testMakeEmployeeAccount() {
		assertTrue(bs.MakeEmployeeAccount(new BankEmployee("goodEmployee", "goodEmployee", new Random().nextInt(100000) ,"goodworker", "workerFamily")));
	}
	
	
}
