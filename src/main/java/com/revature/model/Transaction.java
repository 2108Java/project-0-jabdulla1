package com.revature.model;

public class Transaction {

	int transactionId;
	int transactionNumber;
	int customerNumber;
	String customerName;
	String customerUserName;
	String transActionType;
	double TransActionAmount;
	
	
	public Transaction(int transactionId, int transactionNumber, int customerNumber, String customerName,
			String customerUserName, String transActionType, double transActionAmount) {
		super();
		this.transactionId = transactionId;
		this.transactionNumber = transactionNumber;
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.customerUserName = customerUserName;
		this.transActionType = transActionType;
		TransActionAmount = transActionAmount;
	}


	public Transaction(int transactionNumber, int customerNumber, String customerName, String customerUserName,
			String transActionType, double transActionAmount) {
		super();
		this.transactionNumber = transactionNumber;
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.customerUserName = customerUserName;
		this.transActionType = transActionType;
		TransActionAmount = transActionAmount;
	}


	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public int getTransactionNumber() {
		return transactionNumber;
	}


	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}


	public int getCustomerNumber() {
		return customerNumber;
	}


	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerUserName() {
		return customerUserName;
	}


	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}


	public String getTransActionType() {
		return transActionType;
	}


	public void setTransActionType(String transActionType) {
		this.transActionType = transActionType;
	}


	public double getTransActionAmount() {
		return TransActionAmount;
	}


	public void setTransActionAmount(double transActionAmount) {
		TransActionAmount = transActionAmount;
	}


	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionNumber=" + transactionNumber
				+ ", customerNumber=" + customerNumber + ", customerName=" + customerName + ", customerUserName="
				+ customerUserName + ", transActionType=" + transActionType + ", TransActionAmount=" + TransActionAmount
				+ "]";
	}
	
	
	
	
	
	
}
