package com.revature.controller;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Scanner;

import com.revature.exception.AccountAlreadyExistsException;
import com.revature.exception.BadEntryException;
import com.revature.model.AccountDAO;
import com.revature.model.Customer;
import com.revature.model.CustomerDAO;
import com.revature.model.TrasactionDAO;
import com.revature.model.UserDAO;
import com.revature.utilities.RandomGenerator;
import com.revature.views.AdminPage;
import com.revature.views.Home;
//import com.revature.views.Login;

public final class PageController {
	
	static Home homePage = new Home("How can we serve you today?");
	static AdminPage adminPage = new AdminPage("ADMIN PAGE \n==========");
	
	private static DecimalFormat doubleType = new DecimalFormat("#.##");
	
//	private static Login loginPage;
	
	public static void navigate(Connection connection) throws BadEntryException, AccountAlreadyExistsException {
		
		Scanner sc = new Scanner(System.in);
		
//		String regex = "[0-9]+";
		String userInput = "";
		Boolean isLoggedIn = false;
		
		homePage.body();
		while (!isLoggedIn) {
			String username = "";
			String password = "";
			userInput = sc.nextLine();
			switch (userInput) {
			case "1" :  // Open new account
				System.out.println("Enter First Name:");
				String firstName = sc.nextLine();
				System.out.println("Enter Last Name:");
				String lastName = sc.nextLine();
				System.out.println("Enter City:");
				String city = sc.nextLine();
				System.out.println("Enter State:");
				String state = sc.nextLine();				
				openNewAccount(connection, firstName, lastName, city, state);
				System.out.println(firstName + " " + lastName + "'s account created");
				getCustomer(connection, firstName, lastName, city, state);
				homePage.body();
				break;
			case "2" : // Login
//				loginPage.enterUserName();
				System.out.println("Enter username:");
				username = sc.nextLine();
//				loginPage.enterUserPassword();
				System.out.println("Enter password:");
				password = sc.nextLine();
				isLoggedIn = requestLogin(connection, username, password);
				break;
			case "exit" : 
				System.out.println("You are logged out");
				return;
			default : 
				throw new BadEntryException();
			}
		}
		
		while (isLoggedIn) {
			System.out.println();
			adminPage.body();
			userInput = sc.nextLine().trim().toLowerCase();
			switch (userInput) {
			case "1" :
				System.out.println("Fetching balance...");
				System.out.println("[Your Balance is] $" + viewBalance(connection, "ACCT-90111"));
				break;
			case "2" :
				System.out.println("How much?");
				Double withdrawAmount = sc.nextDouble();
				System.out.println("Withdrawing money...");
				System.out.println("[Withdrew] " + withdrawAmount + " [New Balance] " + withdrawMoney(connection, "ACCT-90111", withdrawAmount));
				break;
			case "3" :
				System.out.println("How much?");
				Double depositAmount = sc.nextDouble();
				System.out.println("Depositing money...");
				System.out.println("[DEPOSITED] " + depositAmount + "[New Balance] " + depositMoney(connection, "ACCT-90111", depositAmount));
				break;
			case "4" :
				System.out.println("Fetching transactions...");
				TrasactionDAO transactionDAO = new TrasactionDAO(connection);
				System.out.println();
				System.out.println("Trans ID    Acct Type    Date          Time        Amount    Customer ID");
				System.out.println("========    =========    ==========    ========    ======    ===========");
				transactionDAO.getAllTransactions().forEach(
					(transaction) -> System.out.println(
						transaction.getTransactionId() + "    " +
						transaction.getAccountType() + "     " +
						transaction.getTransactionDate() + "    " +
						transaction.getTransactionTime() + "    " +
						transaction.getTransactionAmount() + "     " +
						transaction.getCustomerId()
					)
				);
				break;
			case "5" :
				System.out.println("Enter receiving account id: ");
				String receivingAccountId = sc.nextLine();
				System.out.println("Enter transfer amount: ");
				Double transferAmount = sc.nextDouble();
				System.out.println();
				System.out.println("Transferring money...");
				System.out.println("[TRANSFER SUCCESSFUL] New Balance: $" + transferMoney(connection, "ACCT-90111", receivingAccountId, transferAmount));
				break;
			case "exit" :
				System.out.println("You are logged out");
				isLoggedIn = false;
				break;
			default : 
				throw new BadEntryException();
			}
		}
		
		System.out.println("Goodbye!");
		sc.close();
		
	}
	
	private static void openNewAccount(
			Connection connection, 
			String firstName, 
			String lastName,
			String city,
			String state) {
		CustomerDAO customerDAO = new CustomerDAO(connection);
		Properties newCustomerProps = new Properties();
		newCustomerProps.put("firstName", firstName);
		newCustomerProps.put("lastName", lastName);
		newCustomerProps.put("city", city);
		newCustomerProps.put("state", state);
		customerDAO.addNew(newCustomerProps);
		
		AccountDAO accountDAO = new AccountDAO(connection);
		String newAcctNumber = "ACCT-" + RandomGenerator.getNumbers(5);
		while (accountDAO.accountIdExists(newAcctNumber)) {
			newAcctNumber = "ACCT-" + RandomGenerator.getNumbers(5);
		}
		if (!accountDAO.accountIdExists(newAcctNumber)) {
			Properties accountProps = new Properties();
			accountProps.put("accountId", newAcctNumber);
			accountProps.put("accountType", "checking");
			accountProps.put("customerId", customerDAO.getCustomerId("Bugs", "Bunny", "Austin", "Texas"));
			accountDAO.addNew(accountProps);
			accountDAO.updateBalance(newAcctNumber, 4444.44);
		} else {
			System.out.println("Something went wrong");
		}
	}
	
	private static Customer getCustomer(
			Connection connection,
			String firstName,
			String lastName,
			String city,
			String state
			) {
		CustomerDAO customerDAO = new CustomerDAO(connection);
		String customerId = customerDAO.getCustomerId(firstName, lastName, city, state);
		return customerDAO.lookup(customerId);
	}
	
	private static String transferMoney(Connection connection, String fromAccountId, String toAccountId, Double fromAccountIdAmount) {
		AccountDAO accountDAO = new AccountDAO(connection);
		Double newBalance = accountDAO.transferMoney(fromAccountId, toAccountId, fromAccountIdAmount);
		return doubleType.format(newBalance);
	}
	
	private static Double depositMoney(Connection connection, String accountId, Double depositAmount) {
		AccountDAO accountDAO = new AccountDAO(connection);
		return accountDAO.depositMoney(accountId, depositAmount);
	}
	
	private static Double withdrawMoney(Connection connection, String customerId, Double amount) {
		AccountDAO accountDAO = new AccountDAO(connection);
		return accountDAO.withdrawMoney(customerId, amount);
	}
	
	private static Double viewBalance(Connection connection, String accountId) {
		AccountDAO accountDAO = new AccountDAO(connection);
		return accountDAO.viewBalance(accountId);
	}
	
	private static Boolean requestLogin(Connection connection, String username, String password) {
		
		UserDAO userDAO = new UserDAO(connection);
		CustomerDAO customerDAO = new CustomerDAO(connection);
		String customerId = customerDAO.getCustomerId("Mickey", "Mouse", "Orlando", "Florida");
		if (userDAO.userExists(customerId)) {
			System.out.println("LOGGING IN...");
			return true;
		}
		
		return false;
	}
}
