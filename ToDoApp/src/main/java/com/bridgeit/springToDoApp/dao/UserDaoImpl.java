package com.bridgeit.springToDoApp.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridgeit.springToDoApp.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory factory;
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	
	public User findById(int id) {
		Session session = factory.openSession();
		User user = session.get(User.class, id);
		System.out.println("User id" + user.getId());
		session.close();
		return user;
	}

	public User findByName(String name) {
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("name", name));
		
		List<User> user = (List<User>)criteria.list();
		return user.get(0);
	}

	public void saveUser(User user) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
	}

	public User loginUser(String email, String password) {
		String name = null;
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		Criterion emailVerify = Restrictions.ilike("email", email);
		Criterion passwordVerify = Restrictions.ilike("password", password);
		LogicalExpression andExp = Restrictions.and(emailVerify, passwordVerify);
		criteria.add(andExp);
		User user = null;
		List result = criteria.list();
		Iterator iterator = result.iterator();
		while (iterator.hasNext()) {
			user = (User) iterator.next();
			name = user.getName();
		}
		session.close();
		return user;
	}
	
}
