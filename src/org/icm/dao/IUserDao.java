package org.icm.dao;

import java.util.Collection;

import org.icm.model.UserMaster;

public interface IUserDao {
	
	int addUser(UserMaster cust);
	
	void updateUser(UserMaster cust);
	
	UserMaster getUser(int id);
	
	Collection<UserMaster> checkUser(String uname, String email);
	
	Collection<UserMaster> getUser(String uname, String pwd);
	
	int deleteUser(int id);

}

