package com.bridgeit.springToDoApp.service;

import com.bridgeit.springToDoApp.model.User;

public interface UserService {

	User findById(int id);

	User findByName(String name);

	void saveUser(User user);
	
	User loginUser(String email, String password);
	
}
