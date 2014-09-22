package com.sapient.equitytradingapp.pm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.pm.actions.LoginAction;
import com.sapient.equitytradingapp.pm.dao.SendForExecutionDAO;

/**
 * Check order status and send order for Execution
 * 
 */
@Component
public class SendForExecutionService {

	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	SendForExecutionDAO sendForExecutionDAO;

	/**
	 * Check order status and send order for Execution
	 * 
	 * @param orderId
	 *            of type Long
	 * @return result - String
	 */
	public void sendOrder(long orderId) {
		logger.info("inside sendOrder method of sendForExecutionService class");
		sendForExecutionDAO.sendOrdersForExecutionDB(orderId);

	}

	public String checkStatus(long orderId) {
		String status = sendForExecutionDAO.checkOrderStatusInDB(orderId);
		return status;
	}

}
