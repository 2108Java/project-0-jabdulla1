package com.revature.view;

import java.util.Scanner;

import com.revature.model.BankCustomer;
import com.revature.service.BankService;

public class ConsoleBankAppImp implements UIBankApp {

	private BankService service;
	
	int logggedIn =0;
	
	
	public ConsoleBankAppImp(BankService bankService){
		this.service= bankService;
	}
	
	/*
	private void printArray(ToDo[] ToDoArray) {
		
		for(int x =0; x< ToDoArray.length; x++) {
			
			if(ToDoArray[x] != null) {
				System.out.println("Id: "+ ToDoArray[x].getId());
				System.out.println("Title: "+ ToDoArray[x].getTitle());
				System.out.println("Description:"+ ToDoArray[x].getDescription());
				System.out.println("Complete: "+ ToDoArray[x].isComplete());
				System.out.println("");
			}
		}
		
	}
	*/
	
	private void DisplayLoginPage() {
		System.out.println("Welcom To Bank App");
		System.out.println("Please Login");
		System.out.println("1) Customer Login");
		System.out.println("2) Employee Login");
		System.out.println("3) Admin Login");
		System.out.println("4) Create Account");
		System.out.println("5) Exit");
	}
	
	private void DisplayCustomerPage() {
		System.out.println("Welcom To Bank App");
		
		System.out.println("View All Accounts");
		
		
		System.out.println("1) Make a Deposit");
		
		System.out.println("2) Make a Withdrawal");
		
		System.out.println("3) View Balance");
		
		System.out.println("4) Apply for a new Account");
		
		System.out.println("5) Post a money transfer to another account");
		System.out.println("6) Accept a money transfer from another account");
		System.out.println("7) Exit");
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
	
	private void DisplayEmployeePage() {
		System.out.println("Welcome To Bank App Create Account Page");
		System.out.println("1) View a log of all transactions");
		
		System.out.println("2) Approve or reject an account registration by a user");
		
		System.out.println("3) View account balances");
		
		System.out.println("4) Exit");
	}
	
	private void DisplayCreateAccount(Scanner sc) {
		
		
		System.out.println("Welcome To Bank App Create Account Page");
		System.out.println("1) Create Customer Account");
		System.out.println("2) Create Employee Account");
		System.out.println("3) Create Admin Account");
		System.out.println("4) Exit");

		
		String input = sc.nextLine();
		boolean running = true;

		while(running) {
			switch(input) {

			case "1":
				BankCustomer bankcustomer = DisplayCreateCustormerAccount(sc);

				this.service.MakeCustomerAccount(bankcustomer);						

				break;
				
			case "4":
				System.out.println("Ok");
				running = false;
				break;

			default:
				System.out.println("Choose a Vaild Option");

			}

		}
		
	}
	
	private BankCustomer DisplayCreateCustormerAccount(Scanner sc) {
		System.out.println("Welcome To Bank App Create Customer Account Page");
		System.out.println("Enter A User Name: ");
		String userName = sc.nextLine();
		
		System.out.println("Enter A Password: ");
		String password = sc.nextLine();
		
		System.out.println("Enter First Name: ");
		String firstName = sc.nextLine();
		System.out.println("Enter Last Name: ");
		String LastName = sc.nextLine();
		
		BankCustomer bankCustomer = new BankCustomer(userName, password, firstName, LastName);
		
		
		//System.out.println("4) Exit");

		return bankCustomer;
	}
	
	private void DisplayCreateEmployeeAccount() {
		System.out.println("Welcome To Bank App Create Employee Account Page");
		System.out.println("Enter A User Name: ");
		
		System.out.println("Enter A Password: ");
		
		System.out.println("4) Exit");

		
	}

	private void DisplayCreateAdminAccount() {
		System.out.println("Welcome To Bank App Create Admin Account Page");
		System.out.println("Enter A User Name: ");
		
		System.out.println("Enter A Password: ");
		
		System.out.println("4) Exit");

		
	}
	private void DisplayEmployeeLoginPage() {
		System.out.println("Welcome To Employee Login Bank App Page");
		System.out.println("Please Login");
		System.out.println("Enter Employee User Name: ");
		
		System.out.println("Enter Employee User Password: ");
		
		System.out.println("5) Exit");
	}

	
	
	private void DisplayAdminLoginPage() {
		System.out.println("Welcome To Admin Login Bank App Page");
		System.out.println("Please Login");
		System.out.println("Enter Admin User Name: ");
		
		System.out.println("Enter Admin User Password: ");
		
		System.out.println("5) Exit");
	}

	private void DisplayCustomerLoginPage() {
		System.out.println("Welcome To Customer Login Bank App Page");
		System.out.println("Please Login");
		System.out.println("Enter Customer User Name: ");
		
		System.out.println("Enter Coustmer User Password: ");
		
		System.out.println("5) Exit");
	}

	
	@Override
	public void DisplayAndRunApp() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		
				boolean running = true;
				Scanner sc = new Scanner(System.in);
				
				while(running) {
					
					DisplayLoginPage();
								
					String input = sc.nextLine();
					
					
					switch(input) {
					
					
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
