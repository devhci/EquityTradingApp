package com.sapient.equitytradingapp.et.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.et.dao.BlockOrderDAO;
import com.sapient.equitytradingapp.et.interfaces.AmendOrderInterface;
import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.pm.dao.OrderDao;
import com.sapient.equitytradingapp.pm.pojo.Order;

@Component
public class AmendOrdersEtService implements AmendOrderInterface {

	@Autowired
	OrderDao orderDao;
	@Autowired
	BlockOrderDAO blockOrderDAO;

	public boolean amendOrder(Order order) {
		
		int orderQuantity = orderDao.getOrderById(order.getOrderId()).getTotalQuantity() ;

		if (order.getBlockOrderId() == null) {
			orderDao.saveUpdatedOrder(order);
			return true;

		}
		BlockOrder blockOrder = blockOrderDAO.getBlockOrderById(order
				.getBlockOrderId());
		if (!blockOrder.getStatus().equalsIgnoreCase("new"))
			return false;
		double stopPrice = blockOrder.getStopPrice();
		double limitPrice = blockOrder.getLimitPrice();
		if (order.getSide().equalsIgnoreCase("buy")) {
			if (order.getLimitPrice() < limitPrice)
				limitPrice = order.getLimitPrice();
			if (order.getStopPrice() > stopPrice)
				stopPrice = order.getStopPrice();
		} else {
			if (order.getLimitPrice() > limitPrice)
				limitPrice = order.getLimitPrice();
			if (order.getStopPrice() < stopPrice)
				stopPrice = order.getStopPrice();
		}
		int quantity = blockOrder.getTotalQuantity() + order.getTotalQuantity()-orderQuantity;
		blockOrder.setTotalQuantity(quantity);
		blockOrder.setOpenQuantity(quantity);
		blockOrder.setStopPrice(stopPrice);
		blockOrder.setLimitPrice(limitPrice);
		orderDao.saveUpdatedOrder(order);
		blockOrderDAO.updateBlockOrder(blockOrder);
		return true;

	}

}
