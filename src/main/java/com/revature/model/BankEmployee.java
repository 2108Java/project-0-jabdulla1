package com.revature.model;

public class BankEmployee extends User{
	private int id;
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	private String firstName;
	private String lastName;
	
	
	public BankEmployee(String userName, String password, String firstname, String lastname) {
		super(userName, password);
		// TODO Auto-generated constructor stub
		
		this.firstName= firstname;
		this.lastName = lastname;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "BankCustomer [firstName=" + firstName + ", lastName=" + lastName + "] "+ super.toString();
	}
	
	
}
