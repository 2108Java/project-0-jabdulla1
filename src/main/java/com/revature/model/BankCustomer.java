package com.revature.model;

public class BankCustomer extends User{

	private int id;
	private int customerNumber;

	private String firstName;
	private String lastName;
	
	
	
	
	public BankCustomer(int id, String userName, String password, int customerNumber, String firstName,
			String lastName) {
		super(userName, password);
		this.id = id;
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}





	public BankCustomer(String userName, String password, int customernumber, String firstname, String lastname) {
		super(userName, password);
		// TODO Auto-generated constructor stub
		this.customerNumber = customernumber;
		this.firstName= firstname;
		this.lastName = lastname;
	}
	
	




	public int getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
		return "\nBankCustomer---- \n CustomerNumber: " + this.customerNumber +"\n "+ super.toString() +"\n FirstName: " + this.firstName				
				+ "\n LastName: " + this.lastName + " ";
	}

/*
	@Override
	public String toString() {
		return "BankCustomer [id=" + this.id + ", customerNumber=" + this.customerNumber + ", firstName=" + this.firstName
				+ ", lastName=" + this.lastName + "]"+ super.toString();
	}
*/

	
	
	
}
