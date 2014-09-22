package com.sapient.equitytradingapp.pm.pojo;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;


public class SecurityShould {

	private Security security;

	@Before
	public void init()
	{
		security = new Security();
	}
	@Test
	public void testGetCusip() {
		assertNull(security.getCusip());
	}

	@Test
	public void testSetCusip() {
		security.setCusip("abcd1234");
		assertEquals("abcd1234", security.getCusip());
	}

	@Test
	public void testGetSymbol() {
		assertNull(security.getSymbol());
	}

	@Test
	public void testSetSymbol() {
		security.setSymbol("INFY");
		assertEquals("INFY", security.getSymbol());
	}

	@Test
	public void testGetSecurityName() {
		assertNull(security.getSecurityName());
	}

	@Test
	public void testSetSecurityName() {
		security.setSecurityName("Infosys");
		assertEquals("Infosys", security.getSecurityName());
	}

	@Test
	public void testGetExpiryDate() {
		assertNull(security.getExpiryDate());
	}

	

}
