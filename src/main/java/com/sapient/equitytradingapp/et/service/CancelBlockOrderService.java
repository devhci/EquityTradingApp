package com.sapient.equitytradingapp.et.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.et.dao.BlockOrderDAO;
import com.sapient.equitytradingapp.et.pojo.BlockOrder;

/**
 * 
 * @author dkumar40 Service class to remove Block Orders
 */
@Component
public class CancelBlockOrderService {

	@Autowired
	private BlockOrderDAO blockOrderDAO;

	/**
	 * Sends List of Block Orders to be removed to DAO class
	 * 
	 * @param blockOrderIdList
	 */
	public void cancelBlockOrder(List<Long> blockOrderIdList) {
		List<BlockOrder> blockOrderList = new ArrayList<BlockOrder>();
		for (Long id : blockOrderIdList) {
			BlockOrder blockOrder = blockOrderDAO.getBlockOrderById(id);
			blockOrderList.add(blockOrder);
		}

		blockOrderDAO.cancelBlockOrder(blockOrderList);
		for (BlockOrder b : blockOrderList) {
			BlockOrder block = blockOrderDAO.getBlockOrderById(b
					.getBlockOrderId());
			blockOrderDAO.deleteDetails(block);

		}

	}

}
