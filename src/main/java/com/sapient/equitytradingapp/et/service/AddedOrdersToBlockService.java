package com.sapient.equitytradingapp.et.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.et.dao.BlockOrderDAO;
import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.pm.dao.OrderDao;
import com.sapient.equitytradingapp.pm.pojo.Order;

@Component
public class AddedOrdersToBlockService {
	@Autowired
	private BlockOrderDAO blockOrderDAO;
	@Autowired
	private OrderDao orderDao;

	public void addOrdersToBlock(Long blockOrderId, List<Long> orderIdList) {
	    List<Order> orderList = new ArrayList<Order>();
		BlockOrder blockOrder = blockOrderDAO.getBlockOrderById(blockOrderId);
		for (Long orderId : orderIdList)
			orderList.add(orderDao.getOrderById(orderId));

		double limitPrice = blockOrder.getLimitPrice();
		double stopPrice = blockOrder.getStopPrice();
		int quantity = blockOrder.getTotalQuantity();
		for (Order order : orderList) {
			quantity = quantity + order.getTotalQuantity();
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

		}
		blockOrder.setLimitPrice(limitPrice);
		blockOrder.setStopPrice(stopPrice);
		blockOrder.setTotalQuantity(quantity);
		blockOrder.setOpenQuantity(quantity);
		blockOrderDAO.updateBlockOrder(blockOrder);
		for (Order order : orderList) {
			order.setBlockOrderId(blockOrder.getBlockOrderId());

			orderDao.saveUpdatedOrder(order);
		}

	}

}
