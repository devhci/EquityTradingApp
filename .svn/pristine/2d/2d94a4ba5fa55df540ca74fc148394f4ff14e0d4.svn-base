package com.sapient.equitytradingapp.et.service;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import com.sapient.equitytradingapp.et.dao.ExecutionDAO;
import com.sapient.equitytradingapp.et.pojo.Execution;

public class ExecutionBlotterServiceShould {

	private ExecutionBlotterService executionBlotterService;
	
	private List<Execution> eList;
		
	@Mock
	ExecutionDAO mockExecutionDao;
	
	public ExecutionBlotterServiceShould(){
		MockitoAnnotations.initMocks(this);
	}
	@Before
	public void init(){
		executionBlotterService=new ExecutionBlotterService();
	}
	@Test
	public void getExecutionsForTrader(){
		executionBlotterService.setExecutionDao(mockExecutionDao);
		when(mockExecutionDao.retreiveExecution("Aakar")).thenReturn(eList);
		assertEquals(eList,executionBlotterService.getExecutionsForTrader("Aakar"));
		
	}

}
