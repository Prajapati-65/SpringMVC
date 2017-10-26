package com.bridgeit.springToDoApp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bridgeit.springToDoApp.dao.UserDao;
import com.bridgeit.springToDoApp.model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public User findById(int id) {
		return userDao.findById(id);
	}

	public User findByName(String name) {

		return userDao.findByName(name);
	}

	public void saveUser(User user) {

		userDao.saveUser(user);
	}

	public User loginUser(String email, String password) {
		return userDao.loginUser(email, password);
	}

}
