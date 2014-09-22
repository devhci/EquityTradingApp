package com.sapient.equitytradingapp.pm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.pojo.Order;

@Repository
public class CancelOrderDao {
	
	EntityManager entityManager;
	@Autowired
	Order order;

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
	public String changeOrderStatusToCancelled(long orderId) {
		
		order=entityManager.find(Order.class, orderId);
		order.setStatus(StringLiterals.CANCELLED);
		entityManager.persist(order);
		return order.getStatus();
				
	}

}
