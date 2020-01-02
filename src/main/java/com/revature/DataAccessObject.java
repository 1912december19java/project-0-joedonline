package com.revature;

import java.util.Properties;

public interface DataAccessObject {

	void update(Properties props);
	void delete(Integer id, String str);
	void addNew(Properties props);
	Integer size();
	
}
