package com.revature;

public interface DAOAccountQueries{

	Double viewBalance(Integer id);
	Double withdrawMoney(Integer id, Double amount);	
	Double updateBalance(Integer id, Double newBalance);
}
