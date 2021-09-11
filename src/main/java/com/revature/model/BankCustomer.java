package com.revature.model;

public class BankCustomer extends User{

	private String firstName;
	private String lastName;
	
	
	public BankCustomer(String userName, String password, String firstname, String lastname) {
		super(userName, password);
		// TODO Auto-generated constructor stub
		
		this.firstName= firstname;
		this.lastName = lastname;
	}


	@Override
	public String toString() {
		return "BankCustomer [firstName=" + firstName + ", lastName=" + lastName + "] "+ super.toString();
	}
	
	
	
	
	
	
}
