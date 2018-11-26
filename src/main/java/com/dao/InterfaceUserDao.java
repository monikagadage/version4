package com.dao;



import java.util.List;

import com.model.Login;
import com.model.User;

public interface InterfaceUserDao {
	
	public int saveUser(User r);

	public boolean validateUser(Login l);

	public List<User> getUser(User l);

}
