package com.sapient.equitytradingapp.et.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.sapient.equitytradingapp.et.pojo.BlockOrder;

public class BlockOrderDAOShould {

	private BlockOrderDAO blockOrderDAO;
	private EntityManager entityManagerTestObject;
	
	@Mock
	BlockOrder blockOrder;
		
	@Before
	public void init(){
		blockOrderDAO=new BlockOrderDAO();
	}
	
	@Test
	public void getEntityManager(){
	
		assertNull(blockOrderDAO.getEntityManager());
	}
	
	@Test
	public void setEntityManager(){
		
		blockOrderDAO.setEntityManager(entityManagerTestObject);
		assertEquals(entityManagerTestObject,blockOrderDAO.getEntityManager());
	}
	
	
	
}

