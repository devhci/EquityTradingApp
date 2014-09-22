package com.sapient.equitytradingapp.et.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sapient.equitytradingapp.et.pojo.Execution;

public class ExecutionBlotterActionShould {
	
	
	private ExecutionBlotterAction executionBlotterAction;
	
	private List<Execution> eList;
	
	
			
	@Before
	public void init()
	{
		executionBlotterAction=new ExecutionBlotterAction();
		
	}

	@Test
	public void getExecutionList(){
		
		
		eList=executionBlotterAction.getExecutionList();
		
		assertNull(eList);
		
	}
	
	@Test
	public void setExecutionList(){
		
		
		executionBlotterAction.setExecutionList(eList);
		assertEquals(eList,executionBlotterAction.getExecutionList());
	}
	
	

}