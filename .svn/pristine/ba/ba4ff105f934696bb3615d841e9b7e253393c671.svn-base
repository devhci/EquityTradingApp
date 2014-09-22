package com.sapient.equitytradingapp.et.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sapient.equitytradingapp.pm.dao.OrderDao;
import com.sapient.equitytradingapp.pm.pojo.Order;
import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

public class OrderServiceShould {
	
	private OrderService orderService;
	private List<Order> orderList;
	
	@Mock
	OrderDao mockOrderDAO;
	
	public OrderServiceShould(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Before
	public void init(){
		orderService=new OrderService();
	}
	@Test
	public void getOrdersForTrader(){
		orderService.setOrderDao(mockOrderDAO);
		when(mockOrderDAO.getOrdersForTrader("Aakar")).thenReturn(orderList);
		assertEquals(orderList,orderService.getOrdersForTrader("Aakar"));
	}

	}
