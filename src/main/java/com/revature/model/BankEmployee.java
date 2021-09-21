package com.revature.model;

import java.util.Random;

public class BankEmployee extends User{
	private int id;
	
	private int employeeNumber;
	
	
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}


	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	private String firstName;
	private String lastName;
	
	
	public BankEmployee(int id, String userName, String password, String firstname, int employeeNumber, String lastname) {
		super(userName, password);
		// TODO Auto-generated constructor stub
		this.id= id;
		this.employeeNumber= employeeNumber;
		this.firstName= firstname;
		this.lastName = lastname;
	}

	
	public BankEmployee(String userName, String password, int employeeNumber ,String firstname, String lastname) {
		super(userName, password);
		// TODO Auto-generated constructor stub
		this.employeeNumber= employeeNumber;
		this.firstName= firstname;
		this.lastName = lastname;
	}


	public BankEmployee(int id, String userName, String password, int employeeNumber, String firstname, String lastname) {
		super(userName, password);
		// TODO Auto-generated constructor stub
		this.id= id;
		this.employeeNumber= employeeNumber;
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
		return "\nBankCustomer---- \n "+super.toString()+"\n FirstName: " + firstName + "\n LastName: " + lastName;
	}
	/*
	@Override
	public String toString() {
		return "BankCustomer [firstName=" + firstName + ", lastName=" + lastName + "] "+ super.toString();
	}*/
	
	
}
