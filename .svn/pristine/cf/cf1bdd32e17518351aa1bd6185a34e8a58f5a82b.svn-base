package com.sapient.equitytradingapp.pm.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.equitytradingapp.et.pojo.Allocation;
import com.sapient.equitytradingapp.pm.pojo.Order;

@Repository
public class ViewPositionFromOrdersDAO {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public List<Order> getPositionDetailsFromDatabase(String username) {
		List<Order> order = new ArrayList<Order>();
		String query = "select o from Order o where manager='"
				+ username
				+ "' and (order_status='completed' or order_status='Partially Executed')";
		TypedQuery<Order> q = entityManager.createQuery(query, Order.class);
		// q.setParameter(1, username);
		List<Order> list = q.getResultList();
		for (Iterator<Order> iter = list.iterator(); iter.hasNext();) {
			Order temp = iter.next();
			order.add(temp);
		}

		return order;

	}

}
