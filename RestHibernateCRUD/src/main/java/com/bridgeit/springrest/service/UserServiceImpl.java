package com.bridgeit.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgeit.springrest.dao.Dao;
import com.bridgeit.springrest.model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	Dao userDao;

	public User findById(int id) {
		return userDao.findById(id);
	}


	public User findByName(String name) {
		return userDao.findByName(name);
	}

	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}

	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}
}