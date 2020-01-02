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
	 * [COMPLETED] "As a user I can login and logout."
	 * [COMPLETED] "As a user I can view my balance."
	 * [COMPLETED] "As a user I can withdraw money."
	 * [COMPLETED] "As a user I can deposit money."
	 * [ In progress... ] "As a user I can register."
	 * [ ] (optional) "As a user I can view all my transactions."
	 * [ ] (optional) "As a user I can transfer money from my account to another account."
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
			
			
			AccountDAO accountDAO = new AccountDAO(connection);
			Properties accountProps = new Properties();
			accountProps.put("accountType", "checking");
			accountProps.put("customerId", "CID-10002");
			accountDAO.addNew(accountProps);
			
			
//			customerDAO.findAll().forEach(System.out::println);
			
//			System.out.println(customerDAO.lookup(0));
			
//			Properties customerProps = new Properties();
//			customerProps.put("firstName", "Mickey");
//			customerProps.put("lastName", "Mouse");
//			customerProps.put("city", "Orlando");
//			customerProps.put("state", "Florida");
//			customerDAO.addNew(customerProps);
			
//			customerDAO.delete(22, "Minnie");
			
//			Properties updateProps = new Properties();
//			Double balance = 210.21;
//			updateProps.put("customer_id", 21);
//			updateProps.put("firstname", "Mickey");
//			updateProps.put("lastname", "Mouse");
//			updateProps.put("city", "Orlando");
//			updateProps.put("state", "Florida");
//			updateProps.put("balance", balance);
////			customerDAO.update(updateProps);
			
//			Double withdrawAmount = 200.50;
//			System.out.println("[WITHDRAWING] $" + withdrawAmount + " ==> New Balance: $" + customerDAO.withdrawMoney(21, withdrawAmount));
			
//			Double amountAfterWithdraw = customerDAO.withdrawMoney(21, withdrawAmount);
//			System.out.println("[NEW BALANCE] $" + amountAfterWithdraw);
			
//			Double depositAmount = 100.50;
//			Double amountAfterDeposit = customerDAO.depositMoney(21, depositAmount);
//			System.out.println("[DEPOSIT] " + depositAmount + " ==> New Balance: " + amountAfterDeposit);
			
//			System.out.println("[TABLE SIZE] ==> " + customerDAO.size());
//			
//			System.out.println();
//			
//			UserDAO userDAO = new UserDAO(connection);
//			Integer userIdMickeyMouse = customerDAO.getCustomerId("Minnie", "Mouse", "Orlando", "Florida");
//			System.out.println("[getCustomerId] " + userIdMickeyMouse);
//			
//			String username = "mickeymouse";
//			String password = "password1";
//			String email = "mickey.mouse@disneymail.fake";
//			Integer registerStatus = userDAO.registerUser(username, password, email, userIdMickeyMouse);
//			switch (registerStatus) { 
//			case 200 :
//				System.out.println("[REGISTER STATUS] " + registerStatus + " USER REGISTRATION SUCCESSFUL");
//				break;
//			case 400 :
//				System.out.println("[REGISTER STATUS] " + registerStatus + " USER REGISTRATION FAILED");
//				break;
//			default :
//				System.out.println("User Registration Exception: Either the user is already registered or doesn't have an account open, or something else went wrong");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
