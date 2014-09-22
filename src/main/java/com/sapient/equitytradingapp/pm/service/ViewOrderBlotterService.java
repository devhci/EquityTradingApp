package com.sapient.equitytradingapp.pm.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.pm.actions.LoginAction;
import com.sapient.equitytradingapp.pm.dao.ViewOrderBlotterDAO;
import com.sapient.equitytradingapp.pm.pojo.Order;

/**
 * Call DAO layer to get Order details of a manager
 */
@Component
public class ViewOrderBlotterService {

	private static Logger logger = Logger.getLogger(LoginAction.class);
	@Autowired
	ViewOrderBlotterDAO viewOrderBlotterDAO;

	/**
	 * Call DAO layer to get Order details of manager
	 * 
	 * @param manager of type string
	 * @return List of Order - List<Order>
	 */
	public List<Order> getOrders(String manager) {

		logger.info("Inside getOrders method of viewOrderBlotterService class");
		List<Order> order = viewOrderBlotterDAO.getOrdersDetails(manager);
		/*
		 * for(Order o : order){
		 * System.out.println(o.getManager()+" "+o.getAccountId()); }
		 */
		return order;

	}

}
