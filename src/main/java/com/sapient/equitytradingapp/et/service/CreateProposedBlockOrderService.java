package com.sapient.equitytradingapp.et.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.et.dao.BlockOrderDAO;
import com.sapient.equitytradingapp.et.dao.ProposedBlockOrderDAO;
import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.et.pojo.ProposedBlockOrder;
import com.sapient.equitytradingapp.pm.dao.OrderDao;
import com.sapient.equitytradingapp.pm.pojo.Order;

@Component
public class CreateProposedBlockOrderService {
	@Autowired
	ProposedBlockOrderDAO proposedBlockOrderDAO;
	@Autowired
	OrderDao orderDao;
	@Autowired
	BlockOrderDAO blockOrderDAO;

	public void createProposedBlock(List<Long> proposedBlockIdList) {
		List<ProposedBlockOrder> proposedBlockOrderList = new ArrayList<ProposedBlockOrder>();
		for (Long proposedBlockId : proposedBlockIdList)
			proposedBlockOrderList.add(proposedBlockOrderDAO
					.getBlockById(proposedBlockId));
		for (ProposedBlockOrder proposedBlockOrder : proposedBlockOrderList) {
			BlockOrder blockOrder = new BlockOrder();
			blockOrder.setLimitPrice(proposedBlockOrder.getLimitPrice());
			blockOrder.setStopPrice(proposedBlockOrder.getStopPrice());
			blockOrder.setSymbol(proposedBlockOrder.getSymbol());
			blockOrder.setSide(proposedBlockOrder.getSide());
			blockOrder.setOpenQuantity(proposedBlockOrder.getTotalQuantity());
			blockOrder.setStatus("new");
			blockOrder.setTotalQuantity(proposedBlockOrder.getTotalQuantity());
			blockOrder.setTrader(proposedBlockOrder.getTrader());
			blockOrder.setBlockOrderType(proposedBlockOrder.getBlockOrderType());
			blockOrder.setQualifier(proposedBlockOrder.getQualifier());
			List<Order> orderList = orderDao.getOrderForSideAndSymbol(
					proposedBlockOrder.getSide(),
					proposedBlockOrder.getSymbol(),
					proposedBlockOrder.getTrader(),
					proposedBlockOrder.getQualifier(),
					proposedBlockOrder.getBlockOrderType()
					);
			blockOrderDAO.createNewBlockOrder(blockOrder, orderList);
		}
	}

}
