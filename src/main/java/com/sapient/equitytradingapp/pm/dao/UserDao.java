package com.sapient.equitytradingapp.pm.dao;

import com.sapient.equitytradingapp.pm.pojo.User;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class UserDao {
	private EntityManager manager;

	public EntityManager getManager() {
		return manager;
	}

	@PersistenceContext
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Transactional
	public User retrieve(String username) {
		User user = manager.find(User.class, username);
		return user;
	}

	@Transactional
	public void save(User u) {
		User user = manager.find(User.class, u.getUsername());
		user.setPassword(u.getPassword());
		manager.merge(user);
	}

}
