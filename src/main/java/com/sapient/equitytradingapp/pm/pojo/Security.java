package com.sapient.equitytradingapp.pm.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * 
 * POJO for "security" table
 * 
 */
@Component
@Entity
@Table(name = "security")
public class Security {

	@Id
	private String cusip;
	@Column(name = "symbol")
	private String symbol;
	@Column(name = "security_name")
	private String securityName;
	@Column(name = "expiry_date")
	private Date expiryDate;

	public String getCusip() {
		return cusip;
	}

	public void setCusip(String cusip) {
		this.cusip = cusip;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
