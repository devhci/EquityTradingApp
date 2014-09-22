package com.sapient.equitytradingapp.pm.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.equitytradingapp.pm.pojo.PortfolioSecurityRelation;

@Repository
public class ViewPortfolioSecurityRelationDAO {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public List<PortfolioSecurityRelation> getRelation(String portfolio) {
		List<PortfolioSecurityRelation> portfolioSecurityRelation = new ArrayList<PortfolioSecurityRelation>();
		TypedQuery<PortfolioSecurityRelation> q = entityManager.createQuery(
				"select pa from PortfolioSecurityRelation pa",
				PortfolioSecurityRelation.class);
		List<PortfolioSecurityRelation> list = q.getResultList();
		for (Iterator<PortfolioSecurityRelation> iter = list.iterator(); iter
				.hasNext();) {
			PortfolioSecurityRelation temp = iter.next();
			if (portfolio.equals(temp.getPortfolioName())) {
				portfolioSecurityRelation.add(temp);
			}
		}
		return portfolioSecurityRelation;
	}
}
