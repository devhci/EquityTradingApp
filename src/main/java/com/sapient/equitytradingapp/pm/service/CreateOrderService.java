package com.sapient.equitytradingapp.pm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.pm.actions.LoginAction;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.dao.CreateOrderDao;
import com.sapient.equitytradingapp.pm.pojo.Order;

/**
 * Call Create Order DAO to pass order to database
 */
@Component
public class CreateOrderService {

	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	CreateOrderDao orderdao;

	/**
	 * Call Create Order DAO method to pass order to database
	 * 
	 * @param order
	 *            of type Order
	 * @return String - "success"
	 */
	public String addorderservice(Order order) {
		logger.info("Inside addorderservice method of CreateOrderService class");
		orderdao.addOrder(order);
		return StringLiterals.SUCCESS;

	}

}
