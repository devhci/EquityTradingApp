package com.sapient.equitytradingapp.pm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.pojo.Order;

@Repository
public class SendForExecutionDAO {

	@Autowired
	Order order;
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public String checkOrderStatusInDB(long orderId) {

		order = entityManager.find(Order.class, orderId);
		return order.getStatus();
	}

	@Transactional
	public void sendOrdersForExecutionDB(long orderId) {

		order = entityManager.find(Order.class, orderId);
		order.setStatus(StringLiterals.SENT);
		entityManager.persist(order);

	}
}
