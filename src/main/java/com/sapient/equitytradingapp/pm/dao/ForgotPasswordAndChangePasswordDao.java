package com.sapient.equitytradingapp.pm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.equitytradingapp.pm.actions.LoginAction;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.pojo.User;

@Component
public class ForgotPasswordAndChangePasswordDao {
	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	User user;

	@Autowired
	User user1;

	private EntityManager manager;

	@PersistenceContext
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Transactional
	public String forgotpassword(String username, String securityAnswer) {
		System.out.println("in dao");
		user = manager.find(User.class, username);
		if (user != null) {

			String dbAnswer = user.getAnswer();

			if (securityAnswer.equalsIgnoreCase(dbAnswer))
				return StringLiterals.SUCCESS;
			else{
				
				logger.info("You entered the wrong answer");
				return StringLiterals.FAILURE;			
			}
		} else
			logger.info("User doesnot exist");
		return StringLiterals.FAILURE;
	}

	@Transactional
	public String changepassword(String newPassword, String confirmPassword) {
		{

			logger.info("in dao of change password");

			System.out.println("username:" + user.getUsername());
			user = manager.find(User.class, user.getUsername());

			if (newPassword.equalsIgnoreCase(confirmPassword)) {
				user1 = manager.find(User.class, user.getUsername());
				user1.setPassword(newPassword);

				logger.info("in change password transacting");

				manager.merge(user1);

				return StringLiterals.SUCCESS;
			} else
				logger.info("Passwords do not match");
			return StringLiterals.FAILURE;
		}

	}
}
