package com.revature.model;

public interface DAOAccountQueries{

	Double viewBalance(String id);
	Double withdrawMoney(String id, Double amount);	
	Double updateBalance(String id, Double newBalance);
	Double depositMoney(String id, Double amount);
	Double transferMoney(String fromId, String toId, Double fromAmount);
	String getAccountId(String firstName, String lastName, String city, String state);
	
}
