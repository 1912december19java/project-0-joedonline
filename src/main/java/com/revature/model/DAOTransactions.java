package com.revature.model;

import java.util.List;

public interface DAOTransactions {
	
	void recordTransaction(String accountType, Double amount, String customerId);
	List<Transaction> getAllTransactions();
	
}
