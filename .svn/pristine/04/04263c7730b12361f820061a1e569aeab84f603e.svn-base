package com.sapient.equitytradingapp.pm.pojo;

import static org.junit.Assert.*;

import org.junit.Test;

import com.opensymphony.xwork2.interceptor.annotations.Before;

public class PortfolioSecurityRelationShould {

	private PortfolioSecurityRelation portfolioSecurityRelation;

	@Before
	public void init()
	{
		portfolioSecurityRelation=new PortfolioSecurityRelation();
	}
	
	@Test
	public void testGetPortfolioName() {
		assertNull(portfolioSecurityRelation.getPortfolioName());
	}

	@Test
	public void testSetPortfolioName() {
		portfolioSecurityRelation.setPortfolioName("Portfolio-1");
		assertEquals("Portfolio-1", portfolioSecurityRelation.getPortfolioName());
	}

	@Test
	public void testGetSecuritySymbol() {
		assertNull(portfolioSecurityRelation.getSecuritySymbol());
	}

	@Test
	public void testSetSecuritySymbol() {
		portfolioSecurityRelation.setSecuritySymbol("INFY");
		assertEquals("INFY", portfolioSecurityRelation.getSecuritySymbol());
	}

	@Test
	public void testGetId() {
		assertNull(portfolioSecurityRelation.getId());
	}

}
