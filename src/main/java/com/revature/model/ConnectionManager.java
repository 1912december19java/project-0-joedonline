package com.revature.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	private String url;
	private String username;
	private String pw;
	
	
	public ConnectionManager(String host, String dbName, String username, String pw) {
		System.out.println("[ConnectionManager] called.");
		
		String protocol = "jdbc:postgresql";
		this.url = protocol + "://" + host + ":5432/" + dbName;
		this.username = username;
		this.pw = pw;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(this.url, this.username, this.pw);
	}
	
}
