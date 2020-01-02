package com.revature;

public interface DAOUsers {
	
	Integer registerUser(String userName, String pw, String emailAddress, Integer id);
	Boolean userExists(Integer id);
	void deleteUser(Integer id);
	
}
