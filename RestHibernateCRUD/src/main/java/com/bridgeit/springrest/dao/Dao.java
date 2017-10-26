package com.bridgeit.springrest.dao;
import java.util.List;

import com.bridgeit.springrest.model.User;


public interface Dao {

	User findById(int id);

	User findByName(String name);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserById(int id);

	List<User> findAllUsers();
	
}
