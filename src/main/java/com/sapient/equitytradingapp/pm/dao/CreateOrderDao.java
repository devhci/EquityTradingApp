package com.sapient.equitytradingapp.pm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.pojo.Order;
import com.sapient.equitytradingapp.pm.pojo.Portfolio;
import com.sapient.equitytradingapp.pm.pojo.Security;

@Repository
public class CreateOrderDao {

	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public void addOrder(Order order) {
		
		order.setStatus(StringLiterals.NEW);

		String manager = (String) ActionContext.getContext().getSession()
				.get("sessionUsername");

		Portfolio portfolio = entityManager.find(Portfolio.class,
				order.getPortfolioName());

		order.setAccountId(Long.parseLong(portfolio.getAccountId()));

		order.setManager(manager);
		//order.setStatus("new");

		List<Security> security = new ArrayList<Security>();

		String symbol = order.getSymbol();

		TypedQuery<Security> query1 = entityManager.createQuery(
				"select o from Security o where o.symbol=?", Security.class);
		query1.setParameter(1, symbol);

		Security security1 = query1.getSingleResult();

		order.setCusip(security1.getCusip());

		entityManager.persist(order);

	}

}
