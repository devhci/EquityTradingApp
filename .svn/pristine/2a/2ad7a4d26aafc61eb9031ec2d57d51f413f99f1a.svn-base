package com.sapient.equitytradingapp.pm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.pm.actions.LoginAction;
import com.sapient.equitytradingapp.pm.dao.ForgotPasswordAndChangePasswordDao;

/**
 * To call forgotPassword function for checking username and security question.
 */
@Component
public class ForgotPasswordService {
	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	ForgotPasswordAndChangePasswordDao forgotPasswordDao;

	/**
	 * Call forgotPassword function for checking username and security question.
	 * 
	 * @param username of type String
	 * @param securityAnswer of type String
	 * @return result-whether username and the security answer match in database
	 */
	public String authenticate(String username, String securityAnswer) {

		logger.info("inside authenticate method of ForgotPasswordService class");
		String result = forgotPasswordDao.forgotpassword(username,
				securityAnswer);
		return result;
	}

}
