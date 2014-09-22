package com.sapient.equitytradingapp.pm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.pm.actions.LoginAction;
import com.sapient.equitytradingapp.pm.dao.ForgotPasswordAndChangePasswordDao;

/**
 * To call change password DAO to perform change password functionality.
 */
@Component
public class ChangePasswordService {
	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	ForgotPasswordAndChangePasswordDao changePasswordDao;

	/**
	 * Call a DAO method to pass new password, confirm password and get result
	 * 
	 * @param newPassword of type String
	 * @param confirmPassword of type String
	 * @return String - result whether change password service is passed or not.
	 */
	public String authenticate(String newPassword, String confirmPassword) {
		logger.info("in change password service");
		String result = changePasswordDao.changepassword(newPassword,
				confirmPassword);
		return result;
	}

}
