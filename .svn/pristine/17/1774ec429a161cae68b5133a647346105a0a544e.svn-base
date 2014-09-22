package com.sapient.equitytradingapp.et.service;

import java.util.List;
import static org.junit.Assert.*;

import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sapient.equitytradingapp.et.dao.AllocationDAO;
import com.sapient.equitytradingapp.et.pojo.Allocation;

public class AllocationBlotterServiceShould {
	
	private AllocationBlotterService allocationBlotterService;
	private List<Allocation> allocationList;
	
	@Mock
	AllocationDAO mockAllocationDAO;
	
	public AllocationBlotterServiceShould(){
		MockitoAnnotations.initMocks(this);
	}
	@Before
	public void init(){
		allocationBlotterService=new AllocationBlotterService();
	}

	@Test
	public void getAllocationsForTrader(){
		allocationBlotterService.setAllocationDAO(mockAllocationDAO);
		when(mockAllocationDAO.retreiveAllocationList("Aakar")).thenReturn(allocationList);
		
		assertEquals(allocationList,allocationBlotterService.getAllocationsForTrader("Aakar"));
;	}

}
