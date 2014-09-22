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
public class GetCorrespondingBlockOrderService {
	@Autowired
	BlockOrderDAO blockOrderDAO;
	@Autowired
	OrderDao orderDao;

	public boolean checkSymbolAndSide(List<Long> orderIdList) {
		List<Order> orderList = new ArrayList<Order>();

		for (Long orderId : orderIdList) {
			Order order = orderDao.getOrderById(orderId);
			orderList.add(order);
		}
		String side = orderList.get(0).getSide();
		String symbol = orderList.get(0).getSymbol();
		String qualifier = orderList.get(0).getOrderQualifier();
		String blockOrdertype = orderList.get(0).getOrderType();
		for (Order order : orderList) {
			if (order.getSide().equalsIgnoreCase(side) != true
					|| order.getSymbol().equalsIgnoreCase(symbol) != true
					||order.getOrderType().equalsIgnoreCase(blockOrdertype)!=true
					||order.getOrderQualifier().equalsIgnoreCase(qualifier)!=true)
				return false;
		}
		return true;
	}

	public List<BlockOrder> getCorrespondingBlocks(List<Long> orderIdList,
			String trader) {
		Order order = orderDao.getOrderById(orderIdList.get(0));
		String side = order.getSide();
		String symbol = order.getSymbol();
		String qualifier = order.getOrderQualifier();
		String blockOrderType = order.getOrderType();
		return blockOrderDAO.getCorrespondingBlocks(side, symbol, trader,qualifier,blockOrderType);
	}

}
