package com.sapient.equitytradingapp.et.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sapient.equitytradingapp.pm.pojo.Order;

public class OrdersActionShould {
	
private OrdersAction ordersAction;
	
	@Before
	public void init()
	{
		ordersAction=new OrdersAction();
	}

	@Test
	public void getOrderList(){
	
		assertNull(ordersAction.getOrderList());
		
	}
	
	@Test
	public void setOrderList(){
		
		List<Order> xyz=null;
		ordersAction.setOrderList(xyz);
		assertNull(ordersAction.getOrderList());
	}
	
	@Test
	public void execute(){
		
		assertEquals("success",ordersAction.execute());
	}

}
