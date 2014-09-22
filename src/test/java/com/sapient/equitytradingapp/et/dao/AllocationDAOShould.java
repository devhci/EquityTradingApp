package com.sapient.equitytradingapp.et.dao;

import static org.junit.Assert.*;

import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.sapient.equitytradingapp.et.pojo.Allocation;

public class AllocationDAOShould {
	
	private AllocationDAO allocationDAO;
	
	@Before
	public void init(){
		
		allocationDAO=new AllocationDAO();
		
	}

	@Test
	public void getEntityManager(){
		assertNull(allocationDAO.getEntityManager());
	}
	
	@Test
	public void setEntityManager(){
		EntityManager entityManager=null;
		allocationDAO.setEntityManager(entityManager);
		assertNull(allocationDAO.getEntityManager());
		
	}
	
	/*@Test
	public void createAllocation(){
		
	    Allocation allocation=new Allocation();
		allocation.setAllocationId("1");
		allocationDAO.createAllocation(allocation);
		assertEquals(allocation,allocationDAO.retreiveAllocation(1));
	}
	
	*/
	@Test
	public void retreiveAllocation(){
		
	}
	
	@Test
	public void updateAllocation(){
		
	}
	
	@Test
	public void deleteExecution(){
		
	}
	
		

}
