package com.sapient.equitytradingapp.pm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.pm.pojo.Order;

@Repository
public class EditDao {

	@Autowired
	private Order order;
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public String checkOrderStatusInDB(long orderId)
	{
		
		order=entityManager.find(Order.class, orderId);
		return order.getStatus();		
	}
	
	@Transactional
	public Order authenticateFromDB(long orderId) 
	{
		
		  order=entityManager.find(Order.class,orderId);
		  return order;
	}

	@Transactional
	public void changeInDB(Order order1) {
		
		Order newOrder = entityManager.merge(order1);
		entityManager.persist(newOrder);

		}

}


