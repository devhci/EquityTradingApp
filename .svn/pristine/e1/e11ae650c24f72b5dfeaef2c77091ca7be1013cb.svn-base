package com.sapient.equitytradingapp.et.pojo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AllocationShould {
	
	
	private Allocation allocation;
	@Before
	public void init()
	{
		allocation=new Allocation();
	}

	@Test
	public void testGetAllocationId() {
		assertNull(allocation.getAllocationId());
	}

	@Test
	public void testSetAllocationId() {
		allocation.setAllocationId(113l);
		assertEquals("113", allocation.getAllocationId());
	}

	@Test
	public void testGetSide() {
		assertNull(allocation.getSide());
	}

	@Test
	public void testSetSide() {
		allocation.setSide("buy");
		assertEquals("buy", allocation.getSide());
	}
	
	@Test
	public void testGetTransactionPrice() {
		assertNull(allocation.getTransactionPrice());
	}

	@Test
	public void testSetTransactionPrice() {
		Double value = 100.0;
		allocation.setTransactionPrice(value);
		assertEquals(Double.valueOf(value), allocation.getTransactionPrice());
	}
	@Test
	public void testGetTransactionFee() {
		assertNull(allocation.getTransactionFee());
	}

	@Test
	public void testSetTransactionFee() {
		Double value = 500.0;
		allocation.setTransactionFee(500.0);
		assertEquals(value, allocation.getTransactionFee());
	}
	@Test
	public void testGetAllocatedQuantity() {
		assertNull(allocation.getAllocatedQuantity());
	}

	@Test
	public void testSetAllocatedQuantity() {
		Integer value = 100;
		allocation.setAllocatedQuantity(value);
		assertEquals(value, allocation.getAllocatedQuantity());
	}
	
	@Test
	public void testGetOpenQuantity() {
		assertNull(allocation.getOpenQuantity());
	}

	@Test
	public void testSetOpenQuantity() {
		Integer value = 11;
		allocation.setOpenQuantity(value);
		assertEquals(value, allocation.getOpenQuantity());
		
	}
	
	@Test
	public void testGetStatus() {
		assertNull(allocation.getStatus());
	}

	@Test
	public void testSetStatus() {
		allocation.setStatus("new");
		assertEquals("new", allocation.getStatus());
	}
	
	

	@Test
	public void testSetOrderId() {
		allocation.setOrderId(234l);
		assertEquals(234l, allocation.getOrderId());
	}
	
	@Test
	public void testGetExecutionId() {
		assertNull(allocation.getExecutionId());

	}
	@Test
	public void testSetExecutionId() {
		allocation.setExecutionId(101);
		assertEquals("101", allocation.getExecutionId());
	}
	
	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
