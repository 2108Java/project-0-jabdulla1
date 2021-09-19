package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.revature.model.AccountTransfer;
import com.revature.model.BankCustomer;
import com.revature.model.BankEmployee;
import com.revature.model.CustomerAccount;
import com.revature.model.Transaction;
import com.revature.model.User;

public class PostgreToDoDatabase implements BankDatabase {
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "jabdulla";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";
	
	
	@Override
	public void insertCustomer(BankCustomer bankcustomer) {
		// TODO Auto-generated method stub
		
		try(Connection con = DriverManager.getConnection(url, username, password)){

///			String sql ="insert into customerLogin (customer_userName, customer_userPassword, customer_number, customer_firstName, customer_lastName) values \r\n"
	//				+ "	('jabdulla', 'jabdulla', 1234, 'jihad', 'abdul-latif');";
			
			
			String sql = "INSERT INTO customerLogin (customer_userName, customer_userPassword, customer_number, customer_firstName, customer_lastName) "
					+ "values (?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, bankcustomer.getUserName());
			ps.setString(2, bankcustomer.getPassword());
			ps.setInt(3, bankcustomer.getCustomerNumber());
			ps.setString(4, bankcustomer.getFirstName());
			ps.setString(5, bankcustomer.getLastName());
			
			
			ps.execute();
			
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public BankCustomer selectCustomerUser(User user) {
		// TODO Auto-generated method stub
		BankCustomer customerLoggedIn =null;
		int loggedIn= 0;
		
		try(Connection con = DriverManager.getConnection(url, username, password)){

			String sql ="SELECT * FROM customerLogin WHERE customer_userName = ? AND customer_userPassword = ?;";
			PreparedStatement ps = con.prepareStatement(sql);

//			ps.setString(1, add.getTitle());
			
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
//			BankCustomer(int id, String userName, String password, int customerNumber, String firstName, String lastName) {
			
			if(rs != null) {
				customerLoggedIn= new BankCustomer(rs.getInt("customer_id"), rs.getString("customer_userName"), rs.getString("customer_userPassword"),
						rs.getInt("customer_number"), rs.getString("customer_firstName"), rs.getString("customer_lastName"));
				loggedIn = 1;
				
				//System.out.println("customerLoggedIn: "+ customerLoggedIn.toString());
				//rs.next();
				
			}
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("customerLoggedIn: "+ customerLoggedIn.toString());

		return customerLoggedIn;
	}


	@Override
	public CustomerAccount[] selectAllAccountsOfCustomer(BankCustomer customerLoggedIn) {
		// TODO Auto-generated method stub
		CustomerAccount[] allOfCustomer = new CustomerAccount[10];
		
		try(Connection con = DriverManager.getConnection(url, username, password)){

			///			insert into customerAccount(customer_account_accountNumber, customer_account_typeOfAccount, customer_account_balance,
			//foreign_customerLogin_key)values 
		//(204309, 'CHECKING', 1231.50, (select customer_id from customerLogin where customer_number = 1234));

						
						//String sql = "INSERT INTO customerAccount(customer_account_accountNumber, customer_account_typeOfAccount, customer_account_balance, "
						//		+ "foreign_customerLogin_key)values "
						//		+ "(?, ?, ?, (SELECT customer_id FROM customerLogin WHERE customer_number = ?));";
						
//			select * from customerAccount  where foreign_customerLogin_key = (select customer_id from customerlogin where customer_number ='1234');
			
					
						String sql = "SELECT * FROM customerAccount  WHERE foreign_customerLogin_key = (SELECT customer_id FROM customerlogin WHERE customer_number = ?);";
						
						PreparedStatement ps = con.prepareStatement(sql);

						ps.setInt(1, customerLoggedIn.getCustomerNumber());
						
						
						ResultSet rs = ps.executeQuery();//rs.getsi
						
						int x=0;
						while((x < 10) && (rs.next())) {
							
							allOfCustomer[x]= new CustomerAccount(rs.getInt("customer_account_accountNumber"), rs.getString("customer_account_typeOfAccount"),
									rs.getDouble("customer_account_balance"), rs.getInt("foreign_customerLogin_key"), rs.getBoolean("customer_account_isapproved"));
									//ToDo(rs.getInt("id"), rs.getString("title"), 
									//rs.getString("decription"), rs.getBoolean("complete"));
							
							x++;
							
						}
						


					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		
		return allOfCustomer;
	}


	@Override
	public void updateCustomerAccount(double amount, int accountNumber) {
		// TODO Auto-generated method stub
		try(Connection con = DriverManager.getConnection(url, username, password)){
		
			String sql = "UPDATE customerAccount SET customer_account_balance = ? WHERE customer_account_accountnumber = ?;	";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, amount);
			ps.setInt(2, accountNumber);
			
/*
			ps.setString(1, bankcustomer.getUserName());
			ps.setString(2, bankcustomer.getPassword());
			ps.setInt(3, bankcustomer.getCustomerNumber());
			ps.setString(4, bankcustomer.getFirstName());
			ps.setString(5, bankcustomer.getLastName());
*/			
			
			ps.execute();
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void insertCustomerAccount(CustomerAccount customerAccount, int customerNumber) {
		// TODO Auto-generated method stub
		try(Connection con = DriverManager.getConnection(url, username, password)){


			/*
						String sql = "INSERT INTO customerLogin (customer_userName, customer_userPassword, customer_number, customer_firstName, customer_lastName) "
								+ "values (?, ?, ?, ?, ?);";
						PreparedStatement ps = con.prepareStatement(sql);

						ps.setString(1, bankcustomer.getUserName());
						ps.setString(2, bankcustomer.getPassword());
						ps.setInt(3, bankcustomer.getCustomerNumber());
						ps.setString(4, bankcustomer.getFirstName());
						ps.setString(5, bankcustomer.getLastName());


						ps.execute();

			 */
			/*
			 * insert into customerAccount(customer_account_accountNumber, customer_account_typeOfAccount, customer_account_balance,
	foreign_customerLogin_key, customer_account_isapproved)values 
(2043069, 'CHECKING', 12361.50, (select customer_id from customerLogin where customer_number = 1234), false);
			*/

			String sql = "INSERT INTO customerAccount(customer_account_accountNumber, customer_account_typeOfAccount, customer_account_balance, "
					+ "foreign_customerLogin_key, customer_account_isapproved) VALUES "
					+ "(?, ?, ?, (SELECT customer_id FROM customerLogin WHERE customer_number = ?), ?);";

			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, customerAccount.getAccountNumber());
			ps.setString(2, customerAccount.getTypeOfAccount());
			ps.setDouble(3, customerAccount.getBalance());
			ps.setInt(4, customerNumber);
			ps.setBoolean(5, customerAccount.isIsapproved());
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public BankEmployee selectEmployeeUser(User user) {
		// TODO Auto-generated method stub
		
		BankEmployee employeeLoggedIn =null;
		int loggedIn= 0;
		
		try(Connection con = DriverManager.getConnection(url, username, password)){

			String sql ="SELECT * FROM employeeLogin WHERE employee_userName = ? AND employee_userPassword = ?;";
			PreparedStatement ps = con.prepareStatement(sql);

//			ps.setString(1, add.getTitle());
			
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
//			BankCustomer(int id, String userName, String password, int customerNumber, String firstName, String lastName) {
			
			if(rs != null) {
				employeeLoggedIn= new BankEmployee(rs.getInt("employee_id"), rs.getString("employee_userName"), rs.getString("employee_userPassword"),
						rs.getInt("employee_number"), rs.getString("employee_firstName"), rs.getString("employee_lastName"));
				loggedIn = 2;
				
				//System.out.println("customerLoggedIn: "+ customerLoggedIn.toString());
				//rs.next();
				
			}
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("customerLoggedIn: "+ customerLoggedIn.toString());

		return employeeLoggedIn;
	}


	@Override
	public void insertEmployee(BankEmployee bankemployee) {
		// TODO Auto-generated method stub
		

		try(Connection con = DriverManager.getConnection(url, username, password)){

///			String sql ="insert into customerLogin (customer_userName, customer_userPassword, customer_number, customer_firstName, customer_lastName) values \r\n"
	//				+ "	('jabdulla', 'jabdulla', 1234, 'jihad', 'abdul-latif');";
			
			
			String sql = "INSERT INTO employeeLogin (employee_userName, employee_userPassword, employee_number, employee_firstName, employee_lastName) "
					+ "values (?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, bankemployee.getUserName());
			ps.setString(2, bankemployee.getPassword());
			ps.setInt(3, bankemployee.getEmployeeNumber());
			ps.setString(4, bankemployee.getFirstName());
			ps.setString(5, bankemployee.getLastName());
			
			
			ps.execute();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public CustomerAccount[] selectAllCustomerAccounts() {
		// TODO Auto-generated method stub
		
		
CustomerAccount[] allOfCustomerAccount = new CustomerAccount[10];
		
		try(Connection con = DriverManager.getConnection(url, username, password)){

			///			insert into customerAccount(customer_account_accountNumber, customer_account_typeOfAccount, customer_account_balance,
			//foreign_customerLogin_key)values 
		//(204309, 'CHECKING', 1231.50, (select customer_id from customerLogin where customer_number = 1234));

						
						//String sql = "INSERT INTO customerAccount(customer_account_accountNumber, customer_account_typeOfAccount, customer_account_balance, "
						//		+ "foreign_customerLogin_key)values "
						//		+ "(?, ?, ?, (SELECT customer_id FROM customerLogin WHERE customer_number = ?));";
						
//			select * from customerAccount  where foreign_customerLogin_key = (select customer_id from customerlogin where customer_number ='1234');
			
					
						String sql = "SELECT * FROM customerAccount;";
						
						PreparedStatement ps = con.prepareStatement(sql);

						//ps.setInt(1, customerLoggedIn.getCustomerNumber());
						
						
						ResultSet rs = ps.executeQuery(); //rs.getsi
						
						int x=0;
						while((x < 10) && (rs.next())) {
							
							allOfCustomerAccount[x]= new CustomerAccount(rs.getInt("customer_account_accountNumber"), rs.getString("customer_account_typeOfAccount"),
									rs.getDouble("customer_account_balance"), rs.getInt("foreign_customerLogin_key"), rs.getBoolean("customer_account_isapproved"));
									//ToDo(rs.getInt("id"), rs.getString("title"), 
									//rs.getString("decription"), rs.getBoolean("complete"));
							
							x++;
							
						}
						


					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		
		return allOfCustomerAccount;
	}


	@Override
	public void updateApproveCustomerAccount(int accountNumber) {
		// TODO Auto-generated method stub
	
		try(Connection con = DriverManager.getConnection(url, username, password)){
			
			String sql = "UPDATE customerAccount SET customer_account_isapproved = true WHERE customer_account_accountnumber = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			ps.setInt(1, accountNumber);
	
			
			ps.execute();
			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void deleteCustomerAccount(int accountNumber) {
		// TODO Auto-generated method stub
		try(Connection con = DriverManager.getConnection(url, username, password)){

			String sql = "DELETE FROM customerAccount WHERE customer_account_accountnumber = ?;";
			PreparedStatement ps = con.prepareStatement(sql);


			ps.setInt(1, accountNumber);


			ps.execute();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void InsertTransferAccount(AccountTransfer accountTransfer) {
		// TODO Auto-generated method stub
		
		try(Connection con = DriverManager.getConnection(url, username, password)){

			String sql = "INSERT INTO accountTransfer(tAccountNumber, startAccountNumber, endAccountNumber, transferAmount, foreign_customerLogin_key, isAccepted ) VALUES \r\n"
					+ "(?, ?, ?, ?,(select customer_id from customerLogin where customer_number = ?), ?);";
			PreparedStatement ps = con.prepareStatement(sql);

			
			/*
			 * int id;
	int tAccountNumber;
	int startAccountNumber;
	int endAccountNumber;
	double transferAmount;
	int customerNumber;
	boolean isAccepted;

			 */
			ps.setInt(1,accountTransfer.gettAccountNumber());
			ps.setInt(2,accountTransfer.getStartAccountNumber());
			ps.setInt(3,accountTransfer.getEndAccountNumber());
			ps.setDouble(4,accountTransfer.getTransferAmount());
			ps.setInt(5,accountTransfer.getCustomerNumber());
			ps.setBoolean(6,accountTransfer.isAccepted());


			ps.execute();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public AccountTransfer[] selectAllAccountTransfersOfCustomer(BankCustomer customerLoggedIn) {
		// TODO Auto-generated method stub
		AccountTransfer[] allOfCustomerTransfer = new AccountTransfer[10];
		
		try(Connection con = DriverManager.getConnection(url, username, password)){
			
						String sql = "SELECT * FROM accountTransfer  WHERE foreign_customerLogin_key = (SELECT customer_id FROM customerlogin WHERE customer_number = ?);";
						
						PreparedStatement ps = con.prepareStatement(sql);

						ps.setInt(1, customerLoggedIn.getCustomerNumber());
						
						
						ResultSet rs = ps.executeQuery();//rs.getsi
						
						/*
						 * accontTransfer_id serial primary key,
	tAccountNumber int unique,
	startAccountNumber int unique,
	endAccountNumber int unique,
	transferAmount real,
	isAccepted boolean,
	foreign_customerLogin_key int references customerLogin(customer_id)
						 * */
						
						int x=0;
						while((x < 10) && (rs.next())) {
							
							allOfCustomerTransfer[x]= new AccountTransfer(rs.getInt("tAccountNumber"), rs.getInt("startAccountNumber"),
									rs.getInt("endAccountNumber"), rs.getDouble("transferAmount"), rs.getInt("foreign_customerLogin_key"), rs.getBoolean("isAccepted"));
									//ToDo(rs.getInt("id"), rs.getString("title"), 
									//rs.getString("decription"), rs.getBoolean("complete"));
							
							x++;
							
						}
						


					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		
		return allOfCustomerTransfer;

	}


	@Override
	public void deleteAccountTransfer(int transferAccountNumber) {
		// TODO Auto-generated method stub
		
		try(Connection con = DriverManager.getConnection(url, username, password)){

			String sql = "DELETE FROM accountTransfer WHERE tAccountNumber = ?;";
			PreparedStatement ps = con.prepareStatement(sql);


			ps.setInt(1, transferAccountNumber);


			ps.execute();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void insertTransAction(Transaction transaction) {
		// TODO Auto-generated method stub
		try(Connection con = DriverManager.getConnection(url, username, password)){

			String sql = "INSERT INTO transActions(transactionNumber, customerNumber, customerName, customerUserName, transActionType, transActionAmount) \r\n"
					+ "VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);


			ps.setInt(1, transaction.getTransactionNumber());
			ps.setInt(2, transaction.getCustomerNumber());
			ps.setString(3, transaction.getCustomerName());
			ps.setString(4, transaction.getCustomerUserName());
			ps.setString(5, transaction.getTransActionType());
			ps.setDouble(6, transaction.getTransActionAmount());


			ps.execute();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public Transaction[] selectAllTransActions() {
		// TODO Auto-generated method stub


		
		Transaction[] allTransaction = new Transaction[10];
		
		try(Connection con = DriverManager.getConnection(url, username, password)){


						String sql = "SELECT * FROM Transactions";
						
						PreparedStatement ps = con.prepareStatement(sql);
						
						ResultSet rs = ps.executeQuery();//rs.getsi
						/*
						transactionId serial primary key,
						transactionNumber int unique not null,
						customerNumber int not null,
						customerName varchar(30),
						customerUserName varchar(30) not null,
						transActionType varchar(15),
						transActionAmount real	*/
						/*
						Transaction(int transactionNumber, int customerNumber, String customerName, String customerUserName,
								String transActionType, double transActionAmount)*/
						
						int x=0;
						while((x < 10) && (rs.next())) {
							
							allTransaction[x]= new Transaction(rs.getInt("transactionId"), rs.getInt("transactionNumber"),rs.getInt("customerNumber"), 
									rs.getString("customerName"), rs.getString("customerUserName"), rs.getString("transActionType"), rs.getDouble("transActionAmount"));
							
							
							x++;
							
						}
						


					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		
		return allTransaction;

	}


	

}
