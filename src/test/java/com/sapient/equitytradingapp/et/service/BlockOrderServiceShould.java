package com.sapient.equitytradingapp.et.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sapient.equitytradingapp.et.dao.BlockOrderDAO;
import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.pm.pojo.Order;

public class BlockOrderServiceShould {
	

	private BlockOrderService blockOrderService;
	
	@Mock
	BlockOrderDAO blockOrderDAO;
	
	
	private List<BlockOrder> mockBlockOrderList;
	
	private	List<Order> mockOrderList;

	public BlockOrderServiceShould(){
		MockitoAnnotations.initMocks(this);
	}
	@Before
	public void init()
	{
		blockOrderService=new BlockOrderService();
	}
	
	
	@Test
public void getBlockOrders(){
		
		blockOrderService.setBlockOrderDAO(blockOrderDAO);
		when(blockOrderDAO.getDetails("Aakar")).thenReturn(mockBlockOrderList);
		assertEquals(mockBlockOrderList,blockOrderService.getBlockOrders("Aakar"));
	}
	
	@Test
	public void getOrders(){

		blockOrderService.setBlockOrderDAO(blockOrderDAO);
		when(blockOrderDAO.getOrderDetails(0)).thenReturn(mockOrderList);
		assertEquals(mockOrderList,blockOrderService.getOrders(0));
		
	}
}

