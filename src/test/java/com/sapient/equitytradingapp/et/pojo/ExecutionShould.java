package com.sapient.equitytradingapp.et.pojo;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ExecutionShould {
     Execution execution;
	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	@Before
	public void init()
	{
		execution=new Execution();
	}

	@Test
	public void testSetExecutionId() {
		execution.setExecutionID(101l);
		assertEquals(101l, execution.getExecutionID());
	}
	@Test
	public void testSetBlockOrderId() {
		Long value=1001l;
		execution.setBlockOrderId(value);
		assertEquals(value, execution.getBlockOrderId());
	}
	@Test
	public void testSetExecutionQuantity() {
		execution.setExecutionQuantity(100);
		assertEquals(100, execution.getExecutionQuantity());
	}
	@Test
	public void testSetTradeExecutionId() {
		execution.setTradeExecutionId(102);
		assertEquals(102,execution.getTradeExecutionId());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testSetExecutionPrice() {
		execution.setExecutionPrice(119.0);
		assertEquals(119.0, execution.getExecutionPrice());
	}
	@Test
	public void testSetStatus() {
		execution.setStatus("new");
		assertEquals("new", execution.getStatus());
	}
	@Test
	public void testSetTransactionTime() {
		@SuppressWarnings("unused")
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		execution.setTransactionTime(date);
		assertEquals(date, execution.getTransactionTime());
	}

}
