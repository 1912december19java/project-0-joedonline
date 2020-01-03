package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import com.revature.controller.PageController;
import com.revature.exception.AccountAlreadyExistsException;
import com.revature.exception.BadEntryException;
import com.revature.model.ConnectionManager;

/**
 * Create an instance of your controller and launch your application.
 *
 * Try not to have any logic at all on this class.
 */
public class Main {
	
	public static void main(String[] args) throws BadEntryException, AccountAlreadyExistsException {
		
		ConnectionManager connectionManager = new ConnectionManager(
			System.getenv("project0banking-host"), 
			System.getenv("project0banking-dbName"), 
			System.getenv("project0banking-username"), 
			System.getenv("project0banking-pw"));
		
		try {
			Connection connection = connectionManager.getConnection();
			PageController.navigate(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
