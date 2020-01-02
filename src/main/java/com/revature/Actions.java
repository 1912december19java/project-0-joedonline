package com.revature;

import java.util.Properties;

public final class Actions {

	static String INSERT() {
		String fields = "customer_id, firstname, lastname, city, state, balance";
		return "INSERT INTO customers (" + fields + ") VALUES (?, ?, ?, ?, ?, ?)";
	}
	
	static String UPDATE(Properties props) {
		return "UPDATE customers SET firstname = ?, lastname = ?, city = ?, state = ?, balance = ? WHERE customer_id = ?;";
	}
	
	static String DELETE() {
		return "DELETE FROM customers WHERE customer_id = ? AND firstname = ?";
	}
	
	static String COUNT() {
		return "SELECT COUNT(*) from customers";
	}
	
	static String GET_ALL() {
		return "SELECT * FROM customers";
	}
	
	/*
	 * Account Actions
	 */
	static String GET_BALANCE(Integer id) {
		return "SELECT balance FROM customers WHERE customer_id = " + id;
	}
	
	static String UPDATE_BALANCE(Integer id, Double newBalance) {
		return "UPDATE customers SET balance = " + newBalance + " WHERE customer_id = " + id;
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
	
}
