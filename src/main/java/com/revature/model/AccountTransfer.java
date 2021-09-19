package com.revature.model;

public class AccountTransfer {

	int id;
	int tAccountNumber;
	int startAccountNumber;
	int endAccountNumber;
	double transferAmount;
	int customerNumber;
	boolean isAccepted;

	
	
	public AccountTransfer(int i, int taccountNumber, int startAccountNumber, int endAccountNumber, double transferAmount,
			 int customerNumber, boolean isAccepted) {
		super();
		// TODO Auto-generated constructor stub
		
		this.id = i;
		this.tAccountNumber = taccountNumber;
		this.startAccountNumber = startAccountNumber;
		this.endAccountNumber = endAccountNumber;
		this.transferAmount = transferAmount;
		this.customerNumber = customerNumber;
		this.isAccepted = isAccepted;
	}



	public AccountTransfer(int tAccountNumber, int startAccountNumber, int endAccountNumber, double transferAmount,
			int customerNumber, boolean isAccepted) {
		super();
		this.tAccountNumber = tAccountNumber;
		this.startAccountNumber = startAccountNumber;
		this.endAccountNumber = endAccountNumber;
		this.transferAmount = transferAmount;
		this.customerNumber = customerNumber;
		this.isAccepted = isAccepted;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int gettAccountNumber() {
		return tAccountNumber;
	}



	public void settAccountNumber(int tAccountNumber) {
		this.tAccountNumber = tAccountNumber;
	}



	public int getStartAccountNumber() {
		return startAccountNumber;
	}



	public void setStartAccountNumber(int startAccountNumber) {
		this.startAccountNumber = startAccountNumber;
	}



	public int getEndAccountNumber() {
		return endAccountNumber;
	}



	public void setEndAccountNumber(int endAccountNumber) {
		this.endAccountNumber = endAccountNumber;
	}



	public double getTransferAmount() {
		return transferAmount;
	}



	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}



	public int getCustomerNumber() {
		return customerNumber;
	}



	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}



	public boolean isAccepted() {
		return isAccepted;
	}



	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}



	@Override
	public String toString() {
		return "AccountTransfer [id=" + id + ", tAccountNumber=" + tAccountNumber + ", startAccountNumber="
				+ startAccountNumber + ", endAccountNumber=" + endAccountNumber + ", transferAmount=" + transferAmount
				+ ", isAccepted=" + isAccepted + "]";
	}

	
	
}
