package com.sapient.equitytradingapp.et.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.et.service.BlockOrderService;


public class BlockOrderActionShould {
	
	private BlockOrderAction blockOrderAction;
	
	@Mock
	BlockOrderService mockBlockOrderService;
	
	@Mock
	List<BlockOrder> blockOrderList;
	
	public BlockOrderActionShould()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Before
	public void init()
	{
		blockOrderAction=new BlockOrderAction();
		
	}

	@Test
	public void getBlockIOrderList(){
		
		assertNull(blockOrderAction.getBlockOrderList());
		
	}
	
	@Test
	public void setBlockIOrderList(){
		
		List<BlockOrder> blockIOrderList=null;
		blockOrderAction.setBlockOrderList(blockIOrderList);
		assertNull(blockOrderAction.getBlockOrderList());
				
	}
	
	@Test
	public void execute(){
	
	   blockOrderAction.setBlockOrderService(mockBlockOrderService);
      	
		assertEquals("success1", blockOrderAction.execute());
	}

}
