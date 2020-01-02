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
			
			System.out.println(customerDAO.viewBalance(21));
			System.out.println(customerDAO.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
