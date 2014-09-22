package com.sapient.equitytradingapp.pm.pojo;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * POJO for Positions
 */
@Component
public class ViewPosition {

	String portfolioName;
	String accountName;
	List<ViewSecurity> securityList;

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public List<ViewSecurity> getSecurityList() {
		return securityList;
	}

	public void setSecurityList(List<ViewSecurity> securityList) {
		this.securityList = securityList;
	}

}
