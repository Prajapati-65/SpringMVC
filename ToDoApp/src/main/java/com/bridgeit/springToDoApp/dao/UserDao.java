package com.bridgeit.springToDoApp.dao;

import com.bridgeit.springToDoApp.model.User;

public interface UserDao {

	User findById(int id);

	User findByName(String name);

	void saveUser(User user);
	
	User loginUser(String email , String password);

}
