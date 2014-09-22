package com.sapient.equitytradingapp.pm.pojo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * POJO for "orders" table
 */
@Component
@Scope("prototype")
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private Long orderId;
	@Column
	private String cusip;
	@Column
	private String symbol;
	@Column(name = "block_order_id")
	private Long blockOrderId;
	@Column(name = "portfolio_name")
	private String portfolioName;
	@Column(name = "acc_id")
	private long accountId;
	@Column(name = "time")
	Date date;
	@Column(name = "total_qty")
	private int totalQuantity;
	@Column(name = "allocated_qty")
	private int allocatedQuantity;
	@Column
	private String side;
	@Column
	private String trader;
	@Column(name = "order_status")
	private String status;
	@Column(name = "expiry_date")
	private Date expiryDate;
	@Column(name = "order_type")
	private String orderType;
	@Column(name = "order_qualifier")
	private String orderQualifier;
	@Column(name = "acc_type")
	private String accountType;
	@Column(name = "stop_price")
	private Double stopPrice;
	@Column(name = "limit_price")
	private Double limitPrice;
	@Column
	private boolean notification;
	@Column
	private String notes;
	@Column
	private String manager;

	

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Long getBlockOrderId() {
		return blockOrderId;
	}

	public void setBlockOrderId(Long blockOrderId) {
		this.blockOrderId = blockOrderId;
	}

	public String getCusip() {
		return cusip;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setCusip(String cusip) {
		this.cusip = cusip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderQualifier() {
		return orderQualifier;
	}

	public void setOrderQualifier(String orderQualifier) {
		this.orderQualifier = orderQualifier;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public Double getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(double stopPrice) {
		this.stopPrice = stopPrice;
	}

	public Double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getAllocatedQuantity() {
		return allocatedQuantity;
	}

	public void setAllocatedQuantity(int allocatedQuantity) {
		this.allocatedQuantity = allocatedQuantity;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean isNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	public void setStopPrice(Double stopPrice) {
		this.stopPrice = stopPrice;
	}

	public void setLimitPrice(Double limitPrice) {
		this.limitPrice = limitPrice;
	}

}
