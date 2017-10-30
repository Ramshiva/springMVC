package com.siva.dao;

import com.siva.model.Login;
import com.siva.model.User;

public interface UserDao {
	
	void register(User user);
	User validateUser(Login login);

}
