package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Create an instance of your controller and launch your application.
 *
 * Try not to have any logic at all on this class.
 */
public class Main {
	
	/*
	 * USER STORIES:
	 * 
	 * [in progress...] "As a user I can login and logout."
	 * [ ] "As a user I can view my balance."
	 * [ ] "As a user I can withdraw money."
	 * [ ] "As a user I can deposit money."
	 * [ ] "As a user I can register."
	 * [ ] (optional) "As a user I can view all my transactions."
	 * [ ] (optional) "As a user I can transfer money from my account to another account."
	 */
	
	/*
	 * FIELDS:
	 * { Customers: customer_id, firstName, lastName, city, state, balance }
	 * { Users: userName, password }
	 * { Transactions: customer_id, transactionType, amount, date }
	 */

	/*
	 * "As a user I can login and logout."
	 * 
	 * { State :: fields }
	 * - userName
	 * - password
	 * - sanitized
	 * 
	 * { Behavior :: methods }
	 * - loginRequest()
	 * - isLoggedIn()
	 * - logoutRequest()
	 */
	
	public static void main(String[] args) {
		
		ConnectionManager connectionManager = new ConnectionManager(
			System.getenv("project0banking-host"), 
			System.getenv("project0banking-dbName"), 
			System.getenv("project0banking-username"), 
			System.getenv("project0banking-pw"));
		
		try {
			Connection connection = connectionManager.getConnection();
			CustomerDAO customerDAO = new CustomerDAO(connection);
			
//			customerDAO.findAll().forEach(System.out::println);
			
			System.out.println(customerDAO.lookup(0));
			
			Properties customerProps = new Properties();
			customerProps.put("firstName", "Mickey");
			customerProps.put("lastName", "Mickey");
			customerProps.put("city", "Orlando");
			customerProps.put("state", "Florida");
//			customerDAO.addNew(customerProps);
			
//			customerDAO.delete(22, "Minnie");
			Properties updateProps = new Properties();
			Double balance = 210.21;
			updateProps.put("customer_id", 21);
			updateProps.put("firstname", "Mickey");
			updateProps.put("lastname", "Mouse");
			updateProps.put("city", "Orlando");
			updateProps.put("state", "Florida");
			updateProps.put("balance", balance);
//			customerDAO.update(updateProps);
			
			System.out.println("[VIEW BALANCE] ==> " + customerDAO.viewBalance(21));
			
//			Double withdrawAmount = 200.50;
//			System.out.println("[WITHDRAWING] $" + withdrawAmount + " ==> New Balance: $" + customerDAO.withdrawMoney(21, withdrawAmount));
			
//			Double amountAfterWithdraw = customerDAO.withdrawMoney(21, withdrawAmount);
//			System.out.println("[NEW BALANCE] $" + amountAfterWithdraw);
			
//			Double depositAmount = 100.50;
//			Double amountAfterDeposit = customerDAO.depositMoney(21, depositAmount);
//			System.out.println("[DEPOSIT] " + depositAmount + " ==> New Balance: " + amountAfterDeposit);
			
			System.out.println("[TABLE SIZE] ==> " + customerDAO.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
