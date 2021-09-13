package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.model.BankCustomer;
import com.revature.model.CustomerAccount;
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
						
						
						ResultSet rs = ps.executeQuery();
						
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

}
