package com.revature.repositories;

import java.util.List;

import com.revature.models.User;

public interface UserDAO {

	public List<User> findAll();
	public User getByUsername(String username);
	public User login(String username, String password);
	
}
