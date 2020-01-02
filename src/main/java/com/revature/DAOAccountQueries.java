package com.revature;

public interface DAOAccountQueries{

	Double viewBalance(Integer id);
	Double withdrawMoney(Integer id, Double amount);	
	Double updateBalance(Integer id, Double newBalance);
	Double depositMoney(Integer id, Double amount);
	Integer getCustomerId(String firstName, String lastName, String city, String state);
	
}
