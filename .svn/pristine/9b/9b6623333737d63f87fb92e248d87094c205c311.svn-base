package com.sapient.equitytradingapp.pm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.equitytradingapp.pm.pojo.Order;

/**
 * Check status for orders requested to be amended and amend passed orders in
 * database
 */
@Repository
public class AmendDAO {

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

	/**
	 * Find order and return its status.
	 * 
	 * @param orderId
	 *            of type long
	 * @return status of order - String
	 */
	@Transactional
	public String checkOrderStatusInDB(long orderId) {

		order = entityManager.find(Order.class, orderId);
		return order.getStatus();
	}

	/**
	 * Retrieve order from database depending on orderId
	 * 
	 * @param orderId
	 *            of type long
	 * @return order - Order
	 */
	@Transactional
	public Order retrieveFromDB(long orderId) {

		order = entityManager.find(Order.class, orderId);
		return order;
	}
}
