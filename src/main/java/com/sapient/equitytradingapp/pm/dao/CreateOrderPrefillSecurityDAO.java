package com.sapient.equitytradingapp.pm.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.equitytradingapp.pm.pojo.Security;


@Repository
public class CreateOrderPrefillSecurityDAO {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public List<Security> getSecurityList() {

		List<Security> security = new ArrayList<Security>();

		TypedQuery<Security> query1 = entityManager.createQuery(
				"select o from Security o", Security.class);
		List<Security> list = query1.getResultList();
		for (Iterator<Security> iter = list.iterator(); iter.hasNext();) {
			Security temp = iter.next();
			security.add(temp);
		}

		return security;
	}

}
