package com.bridgeit.springToDoApp.controller;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeit.springToDoApp.model.User;
import com.bridgeit.springToDoApp.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/adduser/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findById(@PathVariable("id") int id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/adduser/name/{name}", method = RequestMethod.GET)
	public ResponseEntity<User> findByName(@PathVariable("name") String name) {
		User user = userService.findByName(name);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public ResponseEntity<Void> saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	
	

	
	
	
	
	
}


