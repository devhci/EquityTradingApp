package com.sapient.equitytradingapp.et.pojo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlockOrderShould {
private BlockOrder blockOrder;
	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Before
	public void init()
	{
		blockOrder=new BlockOrder();
	}


	@Test
	public void testSetBlockOrderId() {
		Long value=111l;
		blockOrder.setBlockOrderId(value);
		assertEquals(value, blockOrder.getBlockOrderId());
	}

	@Test
	public void testGetSide() {
		assertNull(blockOrder.getSide());
	}

	@Test
	public void testSetSide() {
		blockOrder.setSide("buy");
		assertEquals("buy", blockOrder.getSide());
	}
	
	@Test
	public void testGetSymbol() {
		assertNull(blockOrder.getSymbol());
	}

	@Test
	public void testSetSymbol() {
		blockOrder.setSymbol("testing");
		assertEquals("testing", blockOrder.getSymbol());
	}
	
	@Test
	public void testGetLimitPrice() {
		assertNull(blockOrder.getLimitPrice());
	}

	@Test
	public void testSetLimitPrice() {
		Double value = 112.0;
		blockOrder.setLimitPrice(value);
		assertEquals(value, blockOrder.getLimitPrice());
	}


	@Test
	public void testGetStopPrice() {
		assertNull(blockOrder.getStopPrice());
	}

	@Test
	public void testSetStopPrice() {
		Double value = 192.0;
		blockOrder.setStopPrice(value);
		assertEquals(value, blockOrder.getStopPrice());
	}

	

	@Test
	public void testSetTotalQuantity() {
		blockOrder.setTotalQuantity(100);
		assertEquals(100, blockOrder.getTotalQuantity());
	}

	

	@Test
	public void testSetExecutedQuantity() {
		blockOrder.setExecutedQuantity(10);
		assertEquals(10, blockOrder.getExecutedQuantity());
	}
	
	@Test
	public void testSetOpenQuantity() {
		blockOrder.setOpenQuantity(90);
		assertEquals(90, blockOrder.getOpenQuantity());
	}
	@Test
	public void testGetStatus() {
		assertNull(blockOrder.getStatus());
	}

	@Test
	public void testSetStatus() {
		blockOrder.setStatus("new");
		assertEquals("new", blockOrder.getStatus());
	}
	
}
