package com.revature.repo;

import com.revature.model.BankCustomer;

public class PostgreToDoDatabase implements BankDatabase {
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "jabdulla";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";
	
	
	@Override
	public void insertCustomer(BankCustomer bankcustomer) {
		// TODO Auto-generated method stub
		
	}

}
