package com.sapient.equitytradingapp.et.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.sapient.equitytradingapp.et.pojo.Execution;
import com.sapient.equitytradingapp.pm.dao.UserDao;

public class ExecutionDAOShould {

private ExecutionDAO executionDAO;
private EntityManager manager;
Execution execution;
@Before
public void doBeforeEachTestCase()
{
	//MockitoAnnotations.initMocks(this);
	executionDAO=new ExecutionDAO();
}
@Test
public void testGetEntityManager(){
	assertNull(executionDAO.getEntityManager());
}

@Test
public void testSetEntityManager(){
	executionDAO.setEntityManager(manager);
	assertEquals(manager,executionDAO.getEntityManager());
}

@Test
public void testCreateExecution()
{
	
}
}
