package com.revature.view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.model.AccountTransfer;
import com.revature.model.BankCustomer;
import com.revature.model.BankEmployee;
import com.revature.model.CustomerAccount;
import com.revature.model.Transaction;
import com.revature.model.User;
import com.revature.service.BankService;

public class ConsoleBankAppImp implements UIBankApp {
	private static final Logger loggy = Logger.getLogger(ConsoleBankAppImp.class);
	
	private BankService service;
	
	BankCustomer customerLoggedIn = null;
	BankEmployee employeeLoggedIn = null;
	
	int loggedIn =0;
	
	
	public ConsoleBankAppImp(BankService bankService){
		this.service= bankService;
	}
	
	
	private void printArray(CustomerAccount[] customerAccounts) {
		
		for(int x =0; x< customerAccounts.length; x++) {
			
			
			if(customerAccounts[x] != null) {
				System.out.println(customerAccounts[x].toString());
				
				/*System.out.println("Id: "+ ToDoArray[x].getId());
				System.out.println("Title: "+ ToDoArray[x].getTitle());
				System.out.println("Description:"+ ToDoArray[x].getDescription());
				System.out.println("Complete: "+ ToDoArray[x].isComplete());
				System.out.println("");*/
			}
		}
		
	}
	
private void printArray(AccountTransfer[] accountTransfer) {
		
		for(int x =0; x< accountTransfer.length; x++) {
			
			
			if(accountTransfer[x] != null) {
				System.out.println(accountTransfer[x].toString());
				
				/*System.out.println("Id: "+ ToDoArray[x].getId());
				System.out.println("Title: "+ ToDoArray[x].getTitle());
				System.out.println("Description:"+ ToDoArray[x].getDescription());
				System.out.println("Complete: "+ ToDoArray[x].isComplete());
				System.out.println("");*/
			}
		}
		
	}
	
	
private void printArray(Transaction[] transaction) {
	
	for(int x =0; x< transaction.length; x++) {
		
		
		if(transaction[x] != null) {
			System.out.println(transaction[x].toString());
			
			/*System.out.println("Id: "+ ToDoArray[x].getId());
			System.out.println("Title: "+ ToDoArray[x].getTitle());
			System.out.println("Description:"+ ToDoArray[x].getDescription());
			System.out.println("Complete: "+ ToDoArray[x].isComplete());
			System.out.println("");*/
		}
	}
	
}

	private void DisplayLoginPage() {
		System.out.println("\nWelcome To Bank App");
		System.out.println("Please Login");
		System.out.println("1) Customer Login");
		System.out.println("2) Employee Login");
		System.out.println("3) Create Account");
		System.out.println("4) Exit");
	}
	
	private void DisplayCustomerPage(Scanner sc) {
		
		
		
		boolean running = true;
		
		while(running) {
			
			
			
			System.out.println("\nWelcome "+ customerLoggedIn.getFirstName() +" "+ customerLoggedIn.getLastName()+" To Bank App Customer Page");
			
			System.out.println("View All Accounts");
			CustomerAccount[] customerAccounts = this.service.getAllAccountsOfCustomer(this.customerLoggedIn);
				
			printArray(customerAccounts);
			
			
			System.out.println("1) Make a Deposit");
			
			
			System.out.println("2) Make a Withdrawal");
			
			System.out.println("3) View Balance");
			
			System.out.println("4) Apply for a new Account");
			
			System.out.println("5) Post a money transfer to another account"); ///will have to set two account numbers and amount then update a table
			System.out.println("6) Accept a money transfer from another account");//will need a new table
			System.out.println("7) Logout");
			
			
			
			String input = sc.nextLine();
			
			switch(input) {
			case "1":
				System.out.println("Enter Account Number: ");
				int daccountNumber = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Amount: ");
				double damount = Double.parseDouble(sc.nextLine());
				
				int x;
				for( x = 0; x< customerAccounts.length; x++) {//change for error cheacking 
					if((customerAccounts[x] != null) &&(customerAccounts[x].getAccountNumber() == daccountNumber)&&(customerAccounts[x].isIsapproved() == true)) {
						
						//damount += customerAccounts[x].getBalance();
						
						this.service.MakeDeposit(damount +customerAccounts[x].getBalance(), daccountNumber);
						
			
						
						Transaction deposit = new Transaction(new Random().nextInt(100000), this.customerLoggedIn.getCustomerNumber(), 
								this.customerLoggedIn.getFirstName()+" "+this.customerLoggedIn.getLastName(), this.customerLoggedIn.getUserName(), "DEPOSIT", damount);
						
						this.service.addTransAction(deposit);
						
						loggy.info("deposit made and transactions logged");
						
						break;
					}
				}
				
				//this.service.MakeDeposit(customerAccounts, amount, accountNumber);
				
				break;
				
			case "2":
				
				System.out.println("Enter Account Number: ");
				int waccountNumber = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Amount: ");
				double wamount = Double.parseDouble(sc.nextLine());
				
				//x =0;
				for( x = 0; x< customerAccounts.length; x++) {//change for error cheacking 
					if((customerAccounts[x] != null) &&(customerAccounts[x].getAccountNumber() == waccountNumber)&&(customerAccounts[x].isIsapproved() == true)) {
						
						//wamount = customerAccounts[x].getBalance() - wamount;
						
						this.service.MakeWithdrawal(waccountNumber, customerAccounts[x].getBalance() - wamount);
						
						Transaction withdrawal = new Transaction(new Random().nextInt(100000), this.customerLoggedIn.getCustomerNumber(), 
								this.customerLoggedIn.getFirstName()+" "+this.customerLoggedIn.getLastName(), this.customerLoggedIn.getUserName(), "WITHDRAWAL", wamount);
						
						this.service.addTransAction(withdrawal);
						
						break;
					}
				}
				
				loggy.info("withdrawal made and transactions logged");
				
				break;
				
			case "3":
				
				System.out.println("See Accounts");
				customerAccounts = this.service.getAllAccountsOfCustomer(this.customerLoggedIn);
				
				printArray(customerAccounts);
				
				break;
				
			case "4":
				
				System.out.println("Enter Account Type: ");
				System.out.println("1) Checking: ");
				System.out.println("2) Saving: ");
				int AccountType = Integer.parseInt(sc.nextLine());
				
				String accountType;
				if(AccountType == 1) {
					accountType = "CHECKING";
				}
				else {
					accountType = "SAVING";
				}
				
				System.out.println("Enter Amount: ");
				double createAmount = Double.parseDouble(sc.nextLine());

			
				/*
				 * CustomerAccount(int id, int accountNumber, String typeOfAccount, double balance, boolean isapproved,
			int foreign_customer_key)
	
				*/
				
				this.service.MakeNewCustomerAccount(new CustomerAccount(new Random().nextInt(100000), accountType, createAmount,0 , false ),  this.customerLoggedIn.getCustomerNumber());
				
				loggy.info("new customer account made");
								
				break;
				
			case "5":
				
				//customerAccounts = this.service.getAllAccountsOfCustomer(this.customerLoggedIn);
				
				//printArray(customerAccounts);
				
				
				System.out.println("Enter Start Account Number: ");
				int startAccountNumber = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter End Account Number: ");
				int endAccountNumber = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Amount to Transfer: ");
				double transferAmount = Double.parseDouble(sc.nextLine());
				boolean isAccepted = false;
				int TaccountNumber = new Random().nextInt(100000);
				
				//lsit all of coustomer acconts and update the coustoer account
				//AccountTransfer accountTransfer = new AccountTransfer(0,TaccountNumber, startAccountNumber, endAccountNumber, transferAmount, this.customerLoggedIn.getCustomerNumber(), isAccepted);
				
				for( x = 0; x< customerAccounts.length; x++) {//change for error cheacking 
					if((customerAccounts[x] != null) &&(customerAccounts[x].getAccountNumber() == startAccountNumber)&&(customerAccounts[x].isIsapproved() == true)) {
						
						//transferAmount = customerAccounts[x].getBalance() - transferAmount;//need error check here
						
						this.service.MakeWithdrawal(startAccountNumber, customerAccounts[x].getBalance() - transferAmount);
						break;
					}
				}
				
				AccountTransfer accountTransfer = new AccountTransfer(0,TaccountNumber, startAccountNumber, endAccountNumber, transferAmount, this.customerLoggedIn.getCustomerNumber(), false);
				
				this.service.MakeTransfer(accountTransfer);
				
				Transaction transfer = new Transaction(new Random().nextInt(100000), this.customerLoggedIn.getCustomerNumber(), 
						this.customerLoggedIn.getFirstName()+" "+this.customerLoggedIn.getLastName(), this.customerLoggedIn.getUserName(), "TRANSFER", transferAmount);
				
				this.service.addTransAction(transfer);
				
				loggy.info("transfer made and transaction made");
				
				break;
				
			case "6":
				
				double tAmount=0;
				AccountTransfer[] AccountTransferisAccepted = this.service.getAllCustomerAccountTransfers(this.customerLoggedIn);
				printArray(AccountTransferisAccepted);

				if(AccountTransferisAccepted == null) {
					break;
				}

				System.out.println("Select a Transfer number use tAccountNumber: ");
				int transferAccountNumber = Integer.parseInt(sc.nextLine());

				System.out.println("Do you want to accept or deny a transfer: ");
				System.out.println("1) To accept");
				System.out.println("2) To deny");
				String tInput = sc.nextLine();

				if(tInput.equals("1")) {
					for( x = 0; x< AccountTransferisAccepted.length; x++) {//change for error cheacking 
						if((AccountTransferisAccepted[x] != null) &&(AccountTransferisAccepted[x].gettAccountNumber() == transferAccountNumber)&&(AccountTransferisAccepted[x].isAccepted() == false)) {

							//amount += AccountTransferisAccepted[x].getTransferAmount();
							for(int  y = 0; y< customerAccounts.length; y++) {//change for error cheacking 
								if((customerAccounts[y] != null) &&(customerAccounts[y].getAccountNumber() == AccountTransferisAccepted[x].getEndAccountNumber())&&(customerAccounts[y].isIsapproved() == true)) {

									tAmount = customerAccounts[y].getBalance() + AccountTransferisAccepted[x].getTransferAmount();//need error check here

									this.service.MakeDeposit(tAmount, AccountTransferisAccepted[x].getEndAccountNumber());
									this.service.removeAccountTransfer(transferAccountNumber);
									break;
								}
							}

						}//end of if
						else if(tInput.equals("2")) {
							for( x = 0; x< AccountTransferisAccepted.length; x++) {//change for error cheacking 
								if((AccountTransferisAccepted[x] != null) &&(AccountTransferisAccepted[x].gettAccountNumber() == transferAccountNumber)&&(AccountTransferisAccepted[x].isAccepted() == false)) {

									//amount += AccountTransferisAccepted[x].getTransferAmount();
									for(int  y = 0; y< customerAccounts.length; y++) {//change for error cheacking 
										if((customerAccounts[y] != null) &&(customerAccounts[y].getAccountNumber() == AccountTransferisAccepted[x].getEndAccountNumber())&&(customerAccounts[y].isIsapproved() == true)) {

											tAmount = customerAccounts[y].getBalance() + AccountTransferisAccepted[x].getTransferAmount();//need error check here

											this.service.MakeDeposit(tAmount, AccountTransferisAccepted[x].getStartAccountNumber());
											this.service.removeAccountTransfer(transferAccountNumber);
											break;
										}
									}//end of for
								}
							}//end of for

						}
						else {
							System.out.println("Wrong Selection");
						}

						//this.service.MakeDeposit(AccountTransferisAccepted[x].getTransferAmount(), AccountTransferisAccepted[x].getEndAccountNumber());
						//this.service.removeAccountTransfer(transferAccountNumber);
						break;
					}
				}
				loggy.info("transfer accepted or deny");
				break;
				//this.service.AcceptMoneyTransfer(transferAccountNumber, this.customerLoggedIn.getCustomerNumber());
				
			case "7":
				this.customerLoggedIn = null;
				this.loggedIn =0;
				running = false;
				
				break;
				
				default:
					System.out.print("Not Vaild");
			
			}
			
		}
	
	}
	
	/*
	private void DisplayCustomerDepositPage() {
		System.out.println("Welcom To Bank App");
		System.out.println("Please Login");
		System.out.println("1) Customer Login");
		System.out.println("2) Employee Login");
		System.out.println("3) Admin Login");
		System.out.println("4) Create Account");
		System.out.println("5) Exit");
	}
	
	private void DisplayCustomerWithdrawalPage() {
		System.out.println("Welcom To Bank App");
		System.out.println("Please Login");
		System.out.println("1) Customer Login");
		System.out.println("2) Employee Login");
		System.out.println("3) Admin Login");
		System.out.println("4) Create Account");
		System.out.println("5) Exit");
	}
	*/
	
	private void DisplayEmployeePage(Scanner sc) {
		

		
		boolean running = true;
		
		while(running) {
			
			System.out.println("\nWelcome "+this.employeeLoggedIn.getFirstName()+" "+this.employeeLoggedIn.getLastName()+" To Bank App Employee Page");
			System.out.println("1) View a log of all transactions");
			
			System.out.println("2) Approve or reject an account registration by a user");//need to update the data base to change isapproved, and if not then delete it from the database
																						//need a customer account number and approve and reject
																						// fix up display of customer accounts to print out statments
			System.out.println("3) View account balances");
			
			System.out.println("4) Logout");
			
			//int accountNumber=0;
			
			String input = sc.nextLine();
			
			switch(input) {
			
			case "1":
				System.out.println("\nView All Transactions");
				Transaction[] transActions = this.service.getAllTransActions();
				printArray(transActions);
				
				loggy.info("employee view of all transactions");
				
				break;
			case "2":
				System.out.println("\nView All Account");
				CustomerAccount[] customerAccounts = this.service.getAllCustomerAccounts();
				printArray(customerAccounts);
				
				System.out.println("Enter Account Number of the Customer: ");
				int vaccountNumber = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Approval: ");
				System.out.println("1) Approve: Will mark as approved and it will allow User to use it");
				System.out.println("2) Disaprove: Will remove it from the database and User will have to reapply");
				
				int approval = Integer.parseInt(sc.nextLine());
				
				if(approval == 1) {
					
					this.service.approveCustomerAccount(vaccountNumber);
					
				}else if(approval == 2) {
				
					this.service.removeCustomerAccount(vaccountNumber);
				}
				else {
					System.out.println("Wrong Entry");
				}
				
				loggy.info("approval and denial made of accounts");
				
				break;
			case "3":
				System.out.println("\nView Account Balances");
				CustomerAccount[] customerAccountsB = this.service.getAllCustomerAccounts();
				printArray(customerAccountsB);
				
				loggy.info("accounts viewed");
				break;
			
			case "4":
				this.employeeLoggedIn = null;
				this.loggedIn =0;
				running = false;
				
				break;
				
				default:
					System.out.print("Not Vaild");
			
			}

			
		}
		
	}
	
	private void DisplayCreateAccount(Scanner sc) {
		
	
		boolean running = true;

		while(running) {
			
			System.out.println("\nWelcome To Bank App Create Account Page");
			System.out.println("1) Create Customer Account");
			System.out.println("2) Create Employee Account");
			System.out.println("3) Exit");
			
			String input = sc.nextLine();
			
			switch(input) {

			case "1":
				BankCustomer bankcustomer = DisplayCreateCustormerAccount(sc);

				this.service.MakeCustomerAccount(bankcustomer);						
				running = false;
				loggy.info("bank customer's account created "+bankcustomer.toString());
				
				break;
			case "2":
				BankEmployee bankemployee = DisplayCreateEmployeeAccount(sc);
				this.service.MakeEmployeeAccount(bankemployee);						
				running = false;
				loggy.info("bank employee's account created "+bankemployee.toString());
				break;

			case "3":
				running = false;
				break;

			default:
				System.out.println("Choose a Vaild Option");

			}

		}
		
	}
	
	private BankCustomer DisplayCreateCustormerAccount(Scanner sc) {
		System.out.println("\nWelcome To Bank App Create Customer Account Page");
		System.out.println("Enter A User Name: ");
		String userName = sc.nextLine();
		
		System.out.println("Enter A Password: ");
		String password = sc.nextLine();
		
		System.out.println("Enter First Name: ");
		String firstName = sc.nextLine();
		System.out.println("Enter Last Name: ");
		String LastName = sc.nextLine();
		
		BankCustomer bankCustomer = new BankCustomer(userName, password, new Random().nextInt(100000), firstName, LastName);
		
		//this.service.MakeCustomerAccount(bankCustomer);
		//System.out.println("4) Exit");
		
		return bankCustomer;
	}
	
	private BankEmployee DisplayCreateEmployeeAccount(Scanner sc) {

		System.out.println("Enter A User Name: ");
		String userName = sc.nextLine();
		
		System.out.println("Enter A Password: ");
		String password = sc.nextLine();
		
		System.out.println("Enter First Name: ");
		String firstName = sc.nextLine();
		System.out.println("Enter Last Name: ");
		String LastName = sc.nextLine();
		
		BankEmployee bankEmployee = new BankEmployee(userName, password, new Random().nextInt(100000), firstName, LastName);
		

		return bankEmployee;
		
	}

	private int DisplayEmployeeLoginPage(Scanner sc) {
		System.out.println("\nWelcome To Employee Login Bank App Page");
		System.out.println("Please Login");
		
		System.out.println("Enter Employee User Name: ");
		String userName = sc.nextLine();
		
		
		System.out.println("Enter Employee User Password: ");
		String password = sc.nextLine();
		
		User user = new User(userName, password);
		
		this.employeeLoggedIn = service.loginEmployee(user);
		
		this.loggedIn = 2;
		
		if(this.loggedIn == 2) {
			
			loggy.info("Employee logged in");
			System.out.println(" You are logged in");
		}
		else {
			loggy.warn("Employee failed to log in");
			System.out.println(" You are not logged in");
		}
		
		//System.out.println("5) Exit");
		return this.loggedIn;
	}

	
	

	private int DisplayCustomerLoginPage(Scanner sc) {
		System.out.println("\nWelcome To Customer Login Bank App Page");
		System.out.println("Please Login");
		
		System.out.println("Enter Customer User Name: ");
		String userName = sc.nextLine();
		
		System.out.println("Enter Coustmer User Password: ");
		String password = sc.nextLine();
		
		//this.customerLoggedIn = new BankCustomer(userName, password);
		
		User user = new User(userName, password);
		
		//this.loggedIn = service.loginCustomer(user, this.customerLoggedIn);
		
		this.customerLoggedIn = service.loginCustomer(user);
		this.loggedIn = 1;
		
		if(this.loggedIn == 1) {
			loggy.info("Customer logged in");
			System.out.println(" You are logged in");
		}
		else {
			loggy.info("Customer failed to log in");
			System.out.println(" You are not logged in");
		}
		
		//System.out.println("5) Exit");
		
		return this.loggedIn;
	}

	
	@Override
	public void DisplayAndRunApp() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		
		/*
		 * System.out.println("Welcom To Bank App");
		System.out.println("Please Login");
		System.out.println("1) Customer Login");
		System.out.println("2) Employee Login");
		System.out.println("3) Admin Login");
		System.out.println("4) Create Account");
		System.out.println("5) Exit");
		*/
		
				boolean running = true;
				Scanner sc = new Scanner(System.in);
				//BankCustomer customerLoggedIn = null;
				//BankEmployee employeeLoggedIn = null;
				
				while(running) {
					
					DisplayLoginPage();
								
					String input = sc.nextLine();
					
					
					switch(input) {
					
					case "1":
						
						
						
						this.loggedIn = DisplayCustomerLoginPage(sc);
						this.loggedIn =1;
						if(this.loggedIn == 1) {
							loggy.info("loggedIn cusomer: "+ this.customerLoggedIn.toString());
							//System.out.println("loggedIn cusomer: "+ this.customerLoggedIn.toString());
							this.DisplayCustomerPage(sc);
						}
						else {
							loggy.warn("Customer failed to log in");
							System.out.println("must log in as a Customer");
						}
						
						break;
						
					case "2":
						this.loggedIn =2;
						
						this.loggedIn = DisplayEmployeeLoginPage(sc);
						//DisplayEmployeeLoginPage(sc);
						
						if(this.loggedIn == 2) {
							loggy.info("loggedIn employee: "+ this.employeeLoggedIn.toString());
							//System.out.println("loggedIn cusomer: "+ this.customerLoggedIn.toString());
							this.DisplayEmployeePage(sc);
						}
						else {
							loggy.warn("Employee failed to log in");
							System.out.println("must log in as a Employee");
						}
						
						break;
					
					case "3":
						
						DisplayCreateAccount(sc);						
						
						break;
					
					
					case "4":
						System.out.println("Thank You");
						running = false;
						break;
					default:
						
						loggy.warn("User (weather employee or customer) is not choose the write options");
						System.out.println("Choose a Vaild Option");
					
					}
					
					
				}
				

		
	}

}
