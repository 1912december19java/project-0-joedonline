package com.revature;

public interface DAOUsers {
	
	Integer registerUser(String userName, String pw, String emailAddress, String id);
	Boolean userExists(String id);
	void deleteUser(String id);
	
}
