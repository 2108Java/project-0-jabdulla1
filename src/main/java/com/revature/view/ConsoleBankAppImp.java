package com.revature.view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.revature.model.BankCustomer;
import com.revature.model.BankEmployee;
import com.revature.model.CustomerAccount;
import com.revature.model.User;
import com.revature.service.BankService;

public class ConsoleBankAppImp implements UIBankApp {

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
	
	
	private void DisplayLoginPage() {
		System.out.println("\nWelcome To Bank App");
		System.out.println("Please Login");
		System.out.println("1) Customer Login");
		System.out.println("2) Employee Login");
		System.out.println("3) Admin Login");
		System.out.println("4) Create Account");
		System.out.println("5) Exit");
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
			
			System.out.println("5) Post a money transfer to another account");
			System.out.println("6) Accept a money transfer from another account");
			System.out.println("7) Logout");
			
			
			
			int accountNumber=0;
			double amount=0;
			String input = sc.nextLine();
			
			switch(input) {
			case "1":
				System.out.println("Enter Account Number: ");
				accountNumber = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Amount: ");
				amount = Double.parseDouble(sc.nextLine());
				
				int x;
				for( x = 0; x< customerAccounts.length; x++) {//change for error cheacking 
					if((customerAccounts[x] != null) &&(customerAccounts[x].getAccountNumber() == accountNumber)&&(customerAccounts[x].isIsapproved() == true)) {
						
						amount += customerAccounts[x].getBalance();
						
						this.service.MakeDeposit(amount, accountNumber);
						break;
					}
				}
				
				//this.service.MakeDeposit(customerAccounts, amount, accountNumber);
				
				break;
				
			case "2":
				
				System.out.println("Enter Account Number: ");
				accountNumber = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Amount: ");
				amount = Double.parseDouble(sc.nextLine());
				
				//x =0;
				for( x = 0; x< customerAccounts.length; x++) {//change for error cheacking 
					if((customerAccounts[x] != null) &&(customerAccounts[x].getAccountNumber() == accountNumber)&&(customerAccounts[x].isIsapproved() == true)) {
						
						amount -= customerAccounts[x].getBalance();
						
						this.service.MakeWithdrawal(accountNumber, amount);
						break;
					}
				}
				
				
				break;
				
			case "3":
				
				System.out.println("See Accounts");
				//CustomerAccount[] SeecustomerAccounts = this.service.getAllAccountsOfCustomer(this.customerLoggedIn);
				
				//printArray(SeecustomerAccounts);
				
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
				
								
				break;
				
			case "5":
				
				System.out.println("Enter Start Account Number: ");
				int startAccountNumber = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter End Account Number: ");
				int endAccountNumber = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Amount to Transfer: ");
				int transferAmount = Integer.parseInt(sc.nextLine());
				boolean isAccepted = false;
				int TaccountNumber = new Random().nextInt(100000);
				
				//lsit all of coustomer acconts and update the coustoer account
				//AccountTransfer accountTransfer = new AccountTransfer(0,TaccountNumber startAccountNumber, endAccountNumber, transferAmount, this.customerLoggedIn.getCustomerNumber(), isAccepted);
				
				break;
				
			case "6":
				
				//AccountTransfer[] AccountTransferisAccepted = this.service.getAllCustomerAccountTransfers(this.customerLoggedIn.getCustomerNumber());
				//print(AccountTransfer);
				System.out.println("Which one do you want to excepted: ");
				int transferAccountNumber = Integer.parseInt(sc.nextLine());
				
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
			
			int accountNumber=0;
			double amount=0;
			String input = sc.nextLine();
			
			switch(input) {
			
			case "1":
				break;
			case "2":
				System.out.println("\nView All Account");
				CustomerAccount[] customerAccounts = this.service.getAllCustomerAccounts();
				printArray(customerAccounts);
				
				System.out.println("Enter Account Number: ");
				accountNumber = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Approval: ");
				System.out.println("1) Approve: ");
				System.out.println("2) Disaprove: ");
				
				int approval = Integer.parseInt(sc.nextLine());
				
				if(approval == 1) {
					
					this.service.approveCustomerAccount(accountNumber);
					
				}else if(approval == 2) {
				
					this.service.removeCustomerAccount(accountNumber);
				}
				else {
					System.out.println("Wrong Entry");
				}
				
				
				break;
			case "3":
				System.out.println("\nView Account Balances");
				CustomerAccount[] customerAccountsB = this.service.getAllCustomerAccounts();
				printArray(customerAccountsB);
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
			System.out.println("3) Create Admin Account");
			System.out.println("4) Exit");
			
			String input = sc.nextLine();
			
			switch(input) {

			case "1":
				BankCustomer bankcustomer = DisplayCreateCustormerAccount(sc);

				this.service.MakeCustomerAccount(bankcustomer);						
				running = false;
				break;
			case "2":
				BankEmployee bankemployee = DisplayCreateEmployeeAccount(sc);
				this.service.MakeEmployeeAccount(bankemployee);						
				running = false;
				break;

			case "4":
				
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
		
		
		//System.out.println("4) Exit");

		return bankEmployee;
		
	}

	private void DisplayCreateAdminAccount() {
		System.out.println("Welcome To Bank App Create Admin Account Page");
		System.out.println("Enter A User Name: ");
		
		System.out.println("Enter A Password: ");
		
		System.out.println("4) Exit");

		
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
			
			System.out.println(" You are logged in");
		}
		else {
			System.out.println(" You are not logged in");
		}
		
		//System.out.println("5) Exit");
		return this.loggedIn;
	}

	
	
	private void DisplayAdminLoginPage() {
		System.out.println("Welcome To Admin Login Bank App Page");
		System.out.println("Please Login");
		System.out.println("Enter Admin User Name: ");
		
		System.out.println("Enter Admin User Password: ");
		
		System.out.println("5) Exit");
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
			
			System.out.println(" You are logged in");
		}
		else {
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
						
						this.loggedIn =1;
						
						this.loggedIn = DisplayCustomerLoginPage(sc);
						
						if(this.loggedIn == 1) {
							//System.out.println("loggedIn cusomer: "+ this.customerLoggedIn.toString());
							this.DisplayCustomerPage(sc);
						}
						else {
							System.out.println("must log in as a Customer");
						}
						
						break;
						
					case "2":
						this.loggedIn =2;
						
						this.loggedIn = DisplayEmployeeLoginPage(sc);
						//DisplayEmployeeLoginPage(sc);
						
						if(this.loggedIn == 2) {
							//System.out.println("loggedIn cusomer: "+ this.customerLoggedIn.toString());
							this.DisplayEmployeePage(sc);
						}
						else {
							System.out.println("must log in as a Employee");
						}
						
						break;
					
					case "4":
						
						DisplayCreateAccount(sc);						
						
						break;
					
					/*case "1":
						
						ToDo[] allToDo = this.service.getAllToDo();
						
						printArray(allToDo);
						
						
						break;
					case "2":
						ToDo add = new ToDo();
						
						System.out.println("Enter a Title");
						add.setTitle(sc.nextLine());
						
						System.out.println("Enter a Description");
						add.setDescription(sc.nextLine());
						
						add.setComplete(false);
						
						this.service.addToDo(add);
						
						
						break;
					case "3":
						
						///boolean ok = false;
						System.out.println("Enter ToDo id (0-9):");
						int in = Integer.parseInt(sc.nextLine());
						
						this.service.completeToDo(in);
						
						if(this.service.completeToDo(in)) {
							System.out.println("ToDo Completed");
						}
						else {
							System.out.println("Wrong ToDo id");
						}	
								
						break;
					case "4":
						
						ToDo[] allCompletedToDos;
						
						allCompletedToDos = this.service.getAllCompletedToDos();
						
						
						printArray(allCompletedToDos);
						
						break;
					case "5":

						ToDo[] allInCompletedToDos;

						allInCompletedToDos = this.service.getAllInCompletedToDos();


						printArray(allInCompletedToDos);

						break;
					case "6":
						
						
						System.out.println("Enter ToDo id for deletetion(0-9):");
						int deleteid = Integer.parseInt(sc.nextLine());
						
						this.service.deleteToDo(deleteid);
						
						if(this.service.deleteToDo(deleteid)) {
							System.out.println("ToDo Deleted");
						}
						else {
							System.out.println("Wrong ToDo id");
						}	
						
						break;
					
					case "7":
						System.out.println("Thank You");
						running = false;
						break;
						*/
					case "5":
						System.out.println("Thank You");
						running = false;
						break;
					default:
						System.out.println("Choose a Vaild Option");
					
					}
					
					
				}
				

		
	}

}
