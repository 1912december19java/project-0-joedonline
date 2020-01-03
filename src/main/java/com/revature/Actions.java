package com.revature;

import java.util.Properties;

public final class Actions {

	static String ADD_NEW_CUSTOMER() {
		String fields = "customer_id, firstname, lastname, city, state";
		return "INSERT INTO customers (" + fields + ") VALUES (?, ?, ?, ?, ?)";
	}
	
	static String UPDATE(Properties props) {
		return "UPDATE customers SET firstname = ?, lastname = ?, city = ?, state = ?, balance = ? WHERE customer_id = ?;";
	}
	
	static String DELETE_CUSTOMER() {
		return "DELETE FROM customers WHERE customer_id = ? AND firstname = ?";
	}
	
	static String COUNT_CUSTOMERS() {
		return "SELECT COUNT(*) from customers";
	}
	
	static String GET_CUSTOMER_BY_ID(String customerId) {
		return "SELECT * FROM users WHERE customer_id = '" + customerId + "'";
	}
	
	static String GET_ALL_CUSTOMERS() {
		return "SELECT * FROM customers";
	}
	
	/*
	 * Account Actions
	 */
	static String ADD_NEW_ACCOUNT() {
		return "INSERT INTO accounts (account_id, account_type, balance, customer_id)  VALUES (?, ?, ?, ?)";
	}
	
	static String ACCOUNT_ID_EXISTS(String accountId) {
		return "SELECT * FROM accounts WHERE account_id = '" + accountId + "'";
	}
	
	static String DELETE_ACCOUNT(String customer_id) {
		return "DELETE FROM accounts WHERE customer_id = " + customer_id;
	}
	
	static String COUNT_ACCOUNTS() {
		return "SELECT COUNT(*) FROM accounts";
	}
	
	static String GET_BALANCE(String accountId) {
		return "SELECT balance FROM accounts WHERE account_id = '" + accountId + "'";
	}
	
	static String UPDATE_BALANCE(String accountId, Double newBalance) {
		return "UPDATE accounts SET balance = " + newBalance + " WHERE account_id = '" + accountId + "'";
	}
	
	static String GET_USER_ID() {
		return "SELECT customer_id FROM customers "
				+ "WHERE firstname = ? "
				+ "AND lastname = ? "
				+ "AND city = ? "
				+ "AND state = ?"; 
	}
	
	/*
	 * Users Actions
	 */
	static String REGISTER_USER(String customerId) {
		return "INSERT INTO users (username, pw, emailaddress, customer_id) VALUES (?, ?, ?, '" + customerId + "')";
	}
	
	static String DELETE_USER(String customerId) {
		return "DELETE FROM users WHERE customer_id = " + customerId;
	}
	
	/*
	 * Transactions Actions
	 */
	static String GET_ALL_TRANSACTIONS() {
		return "SELECT * FROM transactions";
	}
	
}
