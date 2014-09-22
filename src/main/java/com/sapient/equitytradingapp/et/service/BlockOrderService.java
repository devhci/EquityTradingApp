package com.sapient.equitytradingapp.et.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sapient.equitytradingapp.et.dao.BlockOrderDAO;
import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.pm.pojo.Order;

@Component
public class BlockOrderService {
	private static Logger logger = Logger.getLogger(BlockOrderService.class);
	@Autowired
	private BlockOrderDAO blockOrderDao;

	public List<BlockOrder> getBlockOrders(String trader) {
		return blockOrderDao.getDetails(trader);
	}

	public List<Order> getOrders(long id) {
		return blockOrderDao.getOrderDetails(id);
	}

	public void setBlockOrderDAO(BlockOrderDAO blockOrderDao) {
		logger.info("Call to Database made");
		this.blockOrderDao = blockOrderDao;
	}

	public String getStatusOfBlock(long blockOrderId) {
		BlockOrder blockOrder=blockOrderDao.getBlockOrderById(blockOrderId);		
		return blockOrder.getStatus();
	}

}
