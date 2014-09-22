package com.sapient.equitytradingapp.pm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.pm.actions.LoginAction;
import com.sapient.equitytradingapp.pm.dao.LoginDao;

/**
 * Call Login DAO method for authentication of user.
 */
@Component
public class LoginService {

	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	LoginDao loginDao;

	/**
	 * Call Login DAO method for authentication of user.
	 * 
	 * @param username of type String
	 * @param password of type String
	 * @return role of user - String type
	 */
	public String authenticateUser(String username, String password) {

		logger.info("inside authenticateUser of LoginService");
		String role = loginDao.authenticateFromDB(username, password);
		return role;
	}

}
