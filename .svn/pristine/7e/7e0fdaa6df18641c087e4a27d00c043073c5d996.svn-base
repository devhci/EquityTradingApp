package com.sapient.equitytradingapp.pm.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * POJO for "portfolio" table
 */
@Component
@Entity
@Table(name = "portfolio")
public class Portfolio {

	@Id
	@Column(name = "portfolio_name")
	private String portfolioName;
	@Column(name = "username")
	private String username;
	@Column(name = "ACCOUNT_ID")
	private String accountId;

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

}
