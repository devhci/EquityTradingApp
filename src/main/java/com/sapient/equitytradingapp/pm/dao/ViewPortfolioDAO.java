package com.sapient.equitytradingapp.pm.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.equitytradingapp.pm.pojo.Portfolio;

@Repository
public class ViewPortfolioDAO {

	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Transactional
	public List<Portfolio> getPortfolio(String username)
	{
		List<Portfolio> portfolio=new ArrayList<Portfolio>();

		TypedQuery<Portfolio> q=entityManager.createQuery("select p from Portfolio p",Portfolio.class);
		List<Portfolio> list=q.getResultList();
		for(Iterator<Portfolio> iter=list.iterator(); iter.hasNext();){
			Portfolio temp=iter.next();
			System.out.println(temp.getAccountId()+" "+temp.getPortfolioName());
			if(temp.getUsername().equals(username)){
				portfolio.add(temp);
			}
		}
		return portfolio;
	}
}
