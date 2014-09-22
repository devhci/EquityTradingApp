package com.sapient.equitytradingapp.pm.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class PortfolioShould {
private Portfolio portfolio;
@Before
public void init()
{
	portfolio=new Portfolio();
}


	@Test
	public void testGetPortfolioName() {
		assertNull(portfolio.getPortfolioName());
	}

	@Test
	public void testSetPortfolioName() {
		portfolio.setPortfolioName("Portfolio_1");
		assertEquals("Portfolio_1", portfolio.getPortfolioName());
	}

	@Test
	public void testGetUsername() {
		assertNull(portfolio.getUsername());
	}

	@Test
	public void testSetUsername() {
		portfolio.setUsername("sweta");
		assertEquals("sweta", portfolio.getUsername());
	}

	@Test
	public void testGetAccountId() {
		assertNull(portfolio.getAccountId());
	}

	@Test
	public void testSetAccountId() {
		portfolio.setAccountId("00012345");
		assertEquals("00012345", portfolio.getAccountId());
	}

}
