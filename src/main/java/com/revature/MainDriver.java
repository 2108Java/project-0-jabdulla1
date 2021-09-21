package com.revature;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.revature.repo.BankDatabase;
import com.revature.repo.PostgreToDoDatabase;
import com.revature.service.BankService;
import com.revature.service.DAOBankService;
import com.revature.view.ConsoleBankAppImp;
//import com.revature.view.ConsoleUIToDoAppImp;
//import com.revature.view.UIToDoApp;

public class MainDriver {

	//public final static Logger loggy = Logger.getLogger(MainDriver.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//loggy.setLevel(Level.WARN);
		
		//loggy.info("Starting the application");
		
		BankDatabase  BankPGDatabase = new PostgreToDoDatabase();
		
		BankService bankService= new DAOBankService(BankPGDatabase);
		
		ConsoleBankAppImp BankApp= new ConsoleBankAppImp(bankService);
		
		BankApp.DisplayAndRunApp();
	}

}
