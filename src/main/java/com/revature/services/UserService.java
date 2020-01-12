package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserDAOImpl;

public class UserService {

	private static UserDAO udao = new UserDAOImpl();
	
	public UserService() {
		
	}
	
	public static List<User> findAll() {
		return udao.findAll();
	}
	
	public static User getByUsername(String username) {
		return udao.getByUsername(username);
	}
	
	public static User login(String username, String password) {
		return udao.login(username, password);
	}

}
