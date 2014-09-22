package com.sapient.equitytradingapp.pm.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * POJO for "account" table
 */
@Component
@Entity
@Table(name = "account")
public class Account {

	@Id
	@Column(name = "account_Id")
	private String accountId;
	@Column(name = "account_name")
	private String accountName;
	@Column(name = "cash_balance")
	private double cashBalance;
	@Column(name = "margin_balance")
	private double marginBalance;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}

	public double getMarginBalance() {
		return marginBalance;
	}

	public void setMarginBalance(double marginBalance) {
		this.marginBalance = marginBalance;
	}

}
