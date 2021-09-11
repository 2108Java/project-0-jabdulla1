package com.revature;

import com.revature.repo.BankDatabase;
import com.revature.repo.PostgreToDoDatabase;
import com.revature.service.BankService;
import com.revature.service.DAOBankService;
import com.revature.view.ConsoleBankAppImp;
//import com.revature.view.ConsoleUIToDoAppImp;
//import com.revature.view.UIToDoApp;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankDatabase  BankPGDatabase = new PostgreToDoDatabase();
		
		BankService bankService= new DAOBankService(BankPGDatabase);
		
		ConsoleBankAppImp BankApp= new ConsoleBankAppImp(bankService);
		
		BankApp.DisplayAndRunApp();
	}

}
