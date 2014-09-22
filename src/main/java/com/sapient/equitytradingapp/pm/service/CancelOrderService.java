package com.sapient.equitytradingapp.pm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.et.interfaces.CancelOrderInterface;
import com.sapient.equitytradingapp.pm.actions.LoginAction;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.dao.CancelOrderDao;

/**
 * To call cancel DAO to check status and send request to cancel order to DAO.
 */

@Component
public class CancelOrderService {

	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	CancelOrderDao cancelOrderDao;
	@Autowired
	CancelOrderInterface cancelOrdersEtService;

	/**
	 * Check status of order and send request to cancel order to DAO
	 * 
	 * @param orderId
	 *            of type long
	 * @return String - status whether order got cancelled or not.
	 */
	public String cancelOrder(long orderId) {
		logger.info("Inside cancelOrder method of CancelOrderService class");
		String status = cancelOrderDao.checkOrderStatusInDB(orderId);

		if (status.equalsIgnoreCase(StringLiterals.NEW))
			status = cancelOrderDao.changeOrderStatusToCancelled(orderId);
		else if (status.equalsIgnoreCase(StringLiterals.SENT)) {
			if (cancelOrdersEtService.cancelOrder(orderId))
				status = cancelOrderDao.checkOrderStatusInDB(orderId);
		}
		return status;
	}

}
