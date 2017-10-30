package com.siva.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.siva.dao.UserDao;
import com.siva.model.Login;
import com.siva.model.User;

public class UserService {
	
	@Autowired
	private UserDao userDao;

	public void register(User user) {
		
		userDao.register(user);
		
	}

	public User validateUser(Login login) {
		
		User user = userDao.validateUser(login);
		return user;
	}

}
