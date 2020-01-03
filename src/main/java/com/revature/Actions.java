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
	
	static String GET_ALL_CUSTOMERS() {
		return "SELECT * FROM customers";
	}
	
	/*
	 * Account Actions
	 */
	static String ADD_NEW_ACCOUNT() {
		return "INSERT INTO accounts (account_type, balance, customer_id)  VALUES (?, ?, ?)";
	}
	
	static String DELETE_ACCOUNT(String customer_id) {
		return "DELETE FROM accounts WHERE customer_id = " + customer_id;
	}
	
	static String COUNT_ACCOUNTS() {
		return "SELECT COUNT(*) FROM accounts";
	}
	
	static String GET_BALANCE(String customerId) {
//		return "SELECT balance FROM accounts WHERE customer_id = " + customerId;
		return "SELECT balance FROM accounts WHERE customer_id = '" + customerId + "'";
	}
	
	static String UPDATE_BALANCE(String customerId, Double newBalance) {
		return "UPDATE accounts SET balance = " + newBalance + " WHERE customer_id = '" + customerId + "'";
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
	static String REGISTER_USER(Integer id) {
		return "INSERT INTO users (username, pw, emailaddress, customer_id) VALUES (?, ?, ?, " + id + ")";
	}
	
	static String DELETE_USER(Integer id) {
		return "DELETE FROM users WHERE customer_id = " + id;
	}
	
	/*
	 * Transactions Actions
	 */
	static String GET_ALL_TRANSACTIONS() {
		return "SELECT * FROM transactions";
	}
	
}
