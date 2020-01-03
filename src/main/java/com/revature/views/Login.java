package com.revature.views;

import java.sql.Connection;
import java.util.Scanner;

import com.revature.model.CustomerDAO;
import com.revature.model.UserDAO;

public class Login extends Page {
	
	Scanner sc = new Scanner(System.in);
	
	public Login() {
		super("Login Page");
		this.body("");
		super.footer();
	}

	@Override
	public void body(String bodyMessage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void body() {
		this.enterUserName();
	}
	
	public void enterUserName() {
		System.out.println("Enter username:");
	}
	
	public void enterUserPassword() {
		System.out.println("Enter password:");
	}
	
	public Boolean requestLogin(Connection connection, String username, String password) {
		
		UserDAO userDAO = new UserDAO(connection);
		CustomerDAO customerDAO = new CustomerDAO(connection);
		String customerId = customerDAO.getCustomerId("Mickey", "Mouse", "Orlando", "Florida");
		if (userDAO.userExists(customerId)) {
			return true;
		}
		
		return false;
	}
	
}
