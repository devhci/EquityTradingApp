package com.sapient.equitytradingapp.pm.pojo;

import org.springframework.stereotype.Component;

/**
 * POJO for Security
 */
@Component
public class ViewSecurity {

	private String symbol;
	private String securityName;
	private long quantity;
	private double price;

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

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
