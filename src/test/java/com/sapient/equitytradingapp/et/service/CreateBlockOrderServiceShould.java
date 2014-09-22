package com.sapient.equitytradingapp.et.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CreateBlockOrderServiceShould {
	
	private CreateBlockOrderService createBlockOrderService ;
	private	List<Long> testOrderIdList;
	
	@Before
	public void init(){
		createBlockOrderService=new CreateBlockOrderService();
	}

	@Test
	public void createBlocks(){
		
		assertTrue(createBlockOrderService.createBlocks(testOrderIdList));
		
	}
}
