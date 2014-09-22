package com.sapient.equitytradingapp.pm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.pm.actions.LoginAction;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.dao.EditDao;
import com.sapient.equitytradingapp.pm.pojo.Order;

/**
 * Call Edit DAO to check order status and edit order depending on status check.
 */
@Component
public class EditService {

	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	private EditDao editDao;
	Order order;

	/**
	 * Check status of order, find order is status is passed and return order.
	 * 
	 * @param orderId
	 *            of type long
	 * @return Order
	 */
	public Order editOrder(long orderId) {
		logger.info("Inside editOrder method of EditService class");
		String status = editDao.checkOrderStatusInDB(orderId);

		if (status.equalsIgnoreCase(StringLiterals.NEW))
			order = editDao.authenticateFromDB(orderId);
		else
			order = null;
		return order;

	}

	/**
	 * Edit Order in Database
	 * 
	 * @param order
	 *            of type Order
	 */
	public void changeValues(Order order2) {
		editDao.changeInDB(order2);

	}

}
