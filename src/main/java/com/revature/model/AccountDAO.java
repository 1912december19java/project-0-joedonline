package com.revature.model;

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
	
	// ACCOUNT MANAGEMENT
	@Override
	public Double viewBalance(String accountId) {
		Double balance = 0.0;
		
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.GET_BALANCE(accountId))) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				balance = resultSet.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	}

	@Override
	public Double withdrawMoney(String customerId, Double amount) {
		Double balance = this.viewBalance(customerId);
		balance -= amount;
		balance = this.updateBalance(customerId, balance);
		return balance;
	}

	@Override
	public Double updateBalance(String accountId, Double newBalance) {
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.UPDATE_BALANCE(accountId, newBalance))) {
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.viewBalance(accountId);
	}

	@Override
	public Double depositMoney(String id, Double amount) {
		Double balance = this.viewBalance(id);
		balance += amount;
		balance = this.updateBalance(id, balance);
		return balance;
	}

	@Override
	public String getCustomerId(String firstName, String lastName, String city, String state) {
		String customerId;
		
		CustomerDAO customerDAO = new CustomerDAO(connection);
		
		customerId = customerDAO.getCustomerId(firstName, lastName, city, state);
		
		return customerId;
	}
	
	@Override
	public Double transferMoney(String fromAccountId, String toAccountId, Double fromAccountIdAmount) {
		
		// GET { fromAccountIdBalance, toAccountIdBalance }
		Double fromAccountIdBalance = this.viewBalance(fromAccountId);
		Double toAccountIdBalance = this.viewBalance(toAccountId);
		
		// CALCULATE NEW { fromAccountIdBalance, toAccountIdBalance }
		fromAccountIdBalance = fromAccountIdBalance - fromAccountIdAmount;
		toAccountIdBalance = toAccountIdBalance + fromAccountIdAmount;
		
		// UPDATE BALANCE { fromAccountId, toAccountId }
		this.updateBalance(fromAccountId, fromAccountIdBalance);
		this.updateBalance(toAccountId, toAccountIdBalance);
		
		// return sender's balance
		return fromAccountIdBalance;
	}

	// ACCOUNT CREATION
	@Override
	public void update(Properties props) {
		
	}

	@Override
	public void delete(String customerId, String str) {
		
	}

	public void addNew(Properties props) {
		String accountId = props.getProperty("accountId");
		String customerId = props.getProperty("customerId");
		String accountType = props.getProperty("accountType");
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.ADD_NEW_ACCOUNT())) {
			statement.setString(1, accountId);
			statement.setString(2, accountType);
			statement.setDouble(3, 0.0);
			statement.setString(4, customerId);
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Boolean accountIdExists(String accountId) {
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.ACCOUNT_ID_EXISTS(accountId))) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getString(1) != null) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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
