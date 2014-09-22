package com.sapient.equitytradingapp.et.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.et.dao.BlockOrderDAO;
import com.sapient.equitytradingapp.et.interfaces.CancelOrderInterface;
import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.pm.dao.OrderDao;
import com.sapient.equitytradingapp.pm.pojo.Order;

@Component
public class CancelOrderEtService implements CancelOrderInterface {
	@Autowired
	OrderDao orderDao;
	@Autowired
	BlockOrderDAO blockOrderDAO;

	public boolean cancelOrder(long orderId) {
		Order order = orderDao.getOrderById(orderId);
		if (order.getBlockOrderId() == null) {
			order.setStatus("cancelled");
			orderDao.saveUpdatedOrder(order);
			return true;
		}
		BlockOrder blockOrder = blockOrderDAO.getBlockOrderById(order.getBlockOrderId());
		
		if (!(blockOrder.getStatus().equalsIgnoreCase("new"))){
			return false;
		}

		List<Order> orderList = new ArrayList<Order>();
		orderList.add(order);
		blockOrderDAO.removeOrdersFromBlockOrder(orderList);
		order.setStatus("cancelled");
		order.setBlockOrderId(null);
		orderDao.saveUpdatedOrder(order);
	    return true;
	}

}
