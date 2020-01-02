package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO implements DAOUsers {

	Connection connection;
	
	public UserDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Integer registerUser(
			String userName, 
			String pw, 
			String emailAddress, 
			Integer id) {
		
		Integer status = 0;
		
		if (!this.userExists(id)) {
			try (PreparedStatement statement = this.connection.prepareStatement(Actions.REGISTER_USER(id))) {
				statement.setString(1, userName);
				statement.setString(2, pw);
				statement.setString(3, emailAddress);
				statement.execute();
				status = 200;
			} catch (SQLException e) {
				status = 400;
//				e.printStackTrace();
			}
		}
		
		return status;
	}

	@Override
	public Boolean userExists(Integer id) {
		CustomerDAO customerDAO = new CustomerDAO(connection);
		return customerDAO.lookup(id) != null ? true : false;
	}
	
}
