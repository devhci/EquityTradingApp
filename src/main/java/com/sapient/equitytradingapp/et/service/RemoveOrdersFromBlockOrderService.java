package com.sapient.equitytradingapp.et.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.et.dao.BlockOrderDAO;
import com.sapient.equitytradingapp.pm.dao.OrderDao;
import com.sapient.equitytradingapp.pm.pojo.Order;

/**
 * Service Class to accept request from action and removing Orders from Block
 * Order
 * 
 * @author aku172
 * 
 */
@Component
public class RemoveOrdersFromBlockOrderService {

	@Autowired
	private BlockOrderDAO blockOrderDao;
	@Autowired
	private OrderDao orderDao;

	/**
	 * Function to remove orders from block order
	 * 
	 * @param orderIdList
	 */
	public void removeOrderFromBlock(List<Long> orderIdList) {
		List<Order> orderList = new ArrayList<Order>();
		for (Long id : orderIdList) {
			Order order = orderDao.getOrderById(id);
			orderList.add(order);
		}
		blockOrderDao.removeOrdersFromBlockOrder(orderList);

	}

}
