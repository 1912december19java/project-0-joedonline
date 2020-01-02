package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class AccountDAO implements DAOAccountQueries, DAOCustomer, DAOCreateUpdateDelete {

	Connection connection;
	
	public AccountDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Double viewBalance(Integer id) {
		Double balance = 0.0;
		
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.GET_BALANCE(id))) {
			ResultSet resultSet = statement.executeQuery();
			Customer c = new Customer();
			while (resultSet.next()) {
				balance = resultSet.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}

	@Override
	public Double withdrawMoney(Integer id, Double amount) {
		Double balance = this.viewBalance(id);
		balance -= amount;
		balance = this.updateBalance(id, balance);
		return balance;
	}

	@Override
	public Double updateBalance(Integer id, Double newBalance) {
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.UPDATE_BALANCE(id, newBalance))) {
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.viewBalance(id);
	}

	@Override
	public Double depositMoney(Integer id, Double amount) {
		Double balance = this.viewBalance(id);
		balance += amount;
		balance = this.updateBalance(id, balance);
		return balance;
	}

	@Override
	public Integer getCustomerId(String firstName, String lastName, String city, String state) {
		Integer id = 0;
		
		CustomerDAO customerDAO = new CustomerDAO(connection);
		
		id = customerDAO.getCustomerId(firstName, lastName, city, state);
		
		return id;
	}

	// ACCOUNT CREATION
	@Override
	public void update(Properties props) {
		
	}

	@Override
	public void delete(String id, String str) {
		
	}

	public void addNew(Properties props) {
		String customerId = props.getProperty("customerId");
		String accountType = props.getProperty("accountType");
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.ADD_NEW_ACCOUNT())) {
			statement.setString(1, accountType);
			statement.setDouble(2, 0.0);
			statement.setString(3, customerId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer size() {
		Integer size = 0;
		
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.COUNT_ACCOUNTS())) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				size = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return size;
	}
	
}
