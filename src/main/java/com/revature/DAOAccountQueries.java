package com.revature;

public interface DAOAccountQueries{

	Double viewBalance(String id);
	Double withdrawMoney(String id, Double amount);	
	Double updateBalance(String id, Double newBalance);
	Double depositMoney(String id, Double amount);
	
}
