package com.revature.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrasactionDAO implements DAOTransactions {

	Connection connection;
	
	public TrasactionDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Transaction> getAllTransactions() {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try (PreparedStatement statement = this.connection.prepareStatement(Actions.GET_ALL_TRANSACTIONS())) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Transaction t = new Transaction();
				t.setTransactionId(resultSet.getString(1));
				t.setAccountType(resultSet.getString(2));
				t.setTransactionDate();
				t.setTransactionTime();
				t.setTransactionAmount(resultSet.getDouble(5));
				t.setCustomerId(resultSet.getString(6));
				transactions.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}
	
}
