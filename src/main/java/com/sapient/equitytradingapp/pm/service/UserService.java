package com.sapient.equitytradingapp.pm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.pm.actions.LoginAction;
import com.sapient.equitytradingapp.pm.dao.UserDao;
import com.sapient.equitytradingapp.pm.pojo.User;

/**
 * To retrieve User using DAO
 */
@Component
public class UserService {
	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	UserDao userDao;

	/**
	 * To check whether User u exist in database or not
	 * @param u of type User
	 * @return boolean result
	 */
	public boolean userExists(User u) {
		User user = userDao.retrieve(u.getUsername());
		if (user == null)
			return false;
		return true;
	}

	/**
	 * Authenticate user from database
	 * @param u of type User
	 * @return boolean result
	 */
	public boolean authenticate(User u) {
		logger.info("inside authenticate method of UserService class");
		User user = userDao.retrieve(u.getUsername());
		if (user.getPassword().equals(u.getPassword()))
			return true;
		return false;
	}

	/**
	 * Check answer from database
	 * @param u
	 * @return
	 */
	public boolean checkAnswer(User u) {
		User user = userDao.retrieve(u.getUsername());
		if (user.getAnswer().equals(u.getAnswer()))
			return true;
		return false;
	}

	/**
	 * Reset password
	 * @param u of type User
	 */
	public void resetPassword(User u) {
		userDao.save(u);
	}

}
