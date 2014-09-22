package com.sapient.equitytradingapp.et.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.et.dao.ProposedBlockOrderDAO;
import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.et.pojo.ProposedBlockOrder;
import com.sapient.equitytradingapp.pm.dao.OrderDao;

@Component
public class ProposedBlockService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ProposedBlockOrderDAO proposedBlockOrderDAO;

	public List<ProposedBlockOrder> getProposedList(String trader) {
		List<BlockOrder> blockOrderList = orderDao.getProposedList(trader);
		for (BlockOrder blockOrder : blockOrderList) {
			blockOrder.getSymbol();
		}
		proposedBlockOrderDAO.deleteRecords();
		for (BlockOrder blockOrder : blockOrderList) {
			ProposedBlockOrder proposedBlockOrder = new ProposedBlockOrder();
			proposedBlockOrder.setLimitPrice(blockOrder.getLimitPrice());
			proposedBlockOrder.setStopPrice(blockOrder.getStopPrice());
			proposedBlockOrder.setSide(blockOrder.getSide());
			proposedBlockOrder.setSymbol(blockOrder.getSymbol());
			proposedBlockOrder.setTotalQuantity(blockOrder.getTotalQuantity());
			proposedBlockOrder.setOpenQuantity(blockOrder.getTotalQuantity());
			proposedBlockOrder.setTrader(blockOrder.getTrader());
			proposedBlockOrder.setBlockOrderType(blockOrder.getBlockOrderType());
			proposedBlockOrder.setQualifier(blockOrder.getQualifier());

			proposedBlockOrderDAO.saveProposedBlockOrder(proposedBlockOrder);
		}
		return proposedBlockOrderDAO.getProposedOrdersForTrader(trader);

	}
}
