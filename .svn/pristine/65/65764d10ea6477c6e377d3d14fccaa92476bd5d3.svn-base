package com.sapient.equitytradingapp.et.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.et.dao.AllocationDAO;
import com.sapient.equitytradingapp.et.dao.BlockOrderDAO;
import com.sapient.equitytradingapp.et.dao.ExecutionDAO;
import com.sapient.equitytradingapp.et.pojo.Allocation;
import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.et.pojo.Execution;
import com.sapient.equitytradingapp.pm.dao.OrderDao;
import com.sapient.equitytradingapp.pm.pojo.Order;

@Component
public class ExecutionBlotterService {
	@Autowired
	private ExecutionDAO executionDao;
	
	@Autowired
	private BlockOrderDAO blockOrderDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private AllocationDAO allocationDao;

	public List<Execution> getExecutionsForTrader(String trader) {
		autoAllocate();
		return executionDao.retreiveExecution(trader);

	}

	private void autoAllocate() {
		List<Execution> executionList=new ArrayList<Execution>();
		executionList=executionDao.getNewExecutions();
		for(Execution execution:executionList)
		{
			BlockOrder blockOrder=blockOrderDao.getBlockOrderById(execution.getBlockOrderId());
			Integer openQuantity=blockOrder.getOpenQuantity();
			String trader=blockOrder.getTrader();
			//Updating block 
			if(execution.getExecutionQuantity()<openQuantity)
			{
				blockOrder.setExecutedQuantity(blockOrder.getExecutedQuantity()+execution.getExecutionQuantity());
				blockOrder.setOpenQuantity(openQuantity-execution.getExecutionQuantity());
				blockOrder.setStatus("Partially Executed");
				blockOrderDao.updateBlockOrder(blockOrder);
			}
			else
			{
				blockOrder.setExecutedQuantity(blockOrder.getExecutedQuantity()+openQuantity);
				blockOrder.setOpenQuantity(0);
				blockOrder.setStatus("Completed");
				blockOrderDao.updateBlockOrder(blockOrder);				
			}
			//Updating orders in the block
			List<Order> orderList=new ArrayList<Order>();
			orderList=blockOrderDao.getSortedOrderDetails(blockOrder.getBlockOrderId());
			int executionQuantity=execution.getExecutionQuantity();
			List<Allocation> allocationList=new ArrayList<Allocation>();
			for(Order order:orderList)
			{
				int totalQuantity=order.getTotalQuantity();
				int allocatedQuantity=order.getAllocatedQuantity();
				int orderOpenQuantity=totalQuantity-allocatedQuantity;
				if(orderOpenQuantity<=executionQuantity)
				{
					allocatedQuantity=allocatedQuantity+orderOpenQuantity;
					order.setAllocatedQuantity(allocatedQuantity);
					order.setStatus("Completed");
					executionQuantity-=orderOpenQuantity;
					orderDao.saveUpdatedOrder(order);
				}
				else if(executionQuantity==0)
				{
					continue;
				}
				else
				{
					allocatedQuantity+=executionQuantity;
					order.setAllocatedQuantity(allocatedQuantity);
					order.setStatus("Partially Executed");
					executionQuantity=0;
					orderDao.saveUpdatedOrder(order);
				}
				Allocation allocation=new Allocation();
				allocation.setSide(order.getSide());
				allocation.setAllocatedQuantity(order.getAllocatedQuantity());
				allocation.setOpenQuantity(order.getTotalQuantity()-order.getAllocatedQuantity());
				allocation.setOrderId(order.getOrderId());
				allocation.setExecutionId(execution.getExecutionID());
				allocation.setStatus("Allocated");
				allocation.setTransactionPrice(execution.getExecutionPrice());
				allocation.setTransactionFee(execution.getExecutionPrice()*execution.getExecutionQuantity()*0.02);
				allocation.setTrader(trader);
				allocationList.add(allocation);
			}
			
			for(Allocation allocation:allocationList)
				allocationDao.createAllocation(allocation);
			
			execution.setStatus("Allocated");
			executionDao.updateExecution(execution);
					
		}
		
	}

	public void setExecutionDao(ExecutionDAO executionDao) {
		this.executionDao = executionDao;
	}

}
