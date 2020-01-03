package com.revature.model;

import java.util.Properties;

public interface DAOCreateUpdateDelete {

	void update(Properties props);
	void delete(String id, String str);
	void addNew(Properties props);
	Integer size();
	
}
