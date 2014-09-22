package com.sapient.equitytradingapp.pm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.pm.dao.CreateOrderPrefillPortfolioNameDAO;
import com.sapient.equitytradingapp.pm.dao.CreateOrderPrefillSecurityDAO;
import com.sapient.equitytradingapp.pm.dao.CreateOrderPrefillTraderDAO;
import com.sapient.equitytradingapp.pm.pojo.Portfolio;
import com.sapient.equitytradingapp.pm.pojo.Security;
import com.sapient.equitytradingapp.pm.pojo.User;

/**
 * Service to send request to fill lists from database for create order form.
 */
@Component
public class CreateOrderPrefillFieldsService {

	List<User> trader;
	List<Portfolio> portfolio;
	List<Security> security;

	@Autowired
	CreateOrderPrefillTraderDAO createOrderPrefillTraderDAO;

	@Autowired
	CreateOrderPrefillPortfolioNameDAO createOrderPrefillPortfolioNameDAO;

	@Autowired
	private CreateOrderPrefillSecurityDAO createOrderPrefillSecurityDao;

	public void setTrader(List<User> trader) {
		this.trader = trader;
	}

	public void setPortfolio(List<Portfolio> portfolio) {
		this.portfolio = portfolio;
	}

	public void setSecurity(List<Security> security) {
		this.security = security;
	}

	/**
	 * Return list of all traders from database.
	 * 
	 * @return List of User - List<user>
	 */
	public List<User> returnTrader() {
		System.out.println("in return trader method of service class");
		trader = new ArrayList<User>();
		trader = createOrderPrefillTraderDAO.prefillTraderDB();
		for (User u : trader)
			System.out.println(u.getUsername());
		System.out.println("in return trader method of service class"
				+ trader.get(0));
		return trader;
	}

	/**
	 * Return list of all portfolio from database
	 * 
	 * @param manager of type String
	 * @return List of Portfolio - List<Portfolio>
	 */
	public List<Portfolio> returnPortfolio(String manager) {
		System.out.println("in return portfolio method of service class");
		portfolio = new ArrayList<Portfolio>();
		portfolio = createOrderPrefillPortfolioNameDAO
				.prefillPortfolioDB(manager);
		for (Portfolio p : portfolio) {
			System.out.println(p.getPortfolioName() + " " + p.getUsername());
		}
		System.out.println("in return portfolio method of service class"
				+ portfolio.get(0));
		return portfolio;
	}

	/**
	 * Return list of all Securities from database.
	 * 
	 * @return List of Security - List<Security>
	 */
	public List<Security> returnSecurity() {
		System.out.println("in return security method of service class");
		security = new ArrayList<Security>();

		security = createOrderPrefillSecurityDao.getSecurityList();
		System.out.println("in return security method of service class"
				+ security.get(0));
		return security;
	}

}
