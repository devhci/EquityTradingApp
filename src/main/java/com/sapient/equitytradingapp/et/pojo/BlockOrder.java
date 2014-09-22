package com.sapient.equitytradingapp.et.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement
@Entity
@Component
@Table(name = "block_order")
public class BlockOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "block_id")
	private Long blockOrderId;
	@Column(name = "side")
	private String side;
	@Column(name = "symbol")
	private String symbol;
	@Column(name = "limit_price")
	private Double limitPrice;
	@Column(name = "stop_price")
	private Double stopPrice;
	@Column(name = "total_quantity")
	private int totalQuantity;
	@Column(name = "executed_quantity")
	private int executedQuantity;
	@Column(name = "open_quantity")
	private int openQuantity;
	@Column
	private String status;
	@Column
	private String trader;
	@Column(name="block_order_type")
	private String blockOrderType;
	@Column
	private String qualifier;

	public Long getBlockOrderId() {
		return blockOrderId;
	}

	public void setBlockOrderId(Long blockOrderId) {
		this.blockOrderId = blockOrderId;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(Double limitPrice) {
		this.limitPrice = limitPrice;
	}

	public Double getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(Double stopPrice) {
		this.stopPrice = stopPrice;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getExecutedQuantity() {
		return executedQuantity;
	}

	public void setExecutedQuantity(int executedQuantity) {
		this.executedQuantity = executedQuantity;
	}

	public int getOpenQuantity() {
		return openQuantity;
	}

	public void setOpenQuantity(int openQuantity) {
		this.openQuantity = openQuantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}

	public String getBlockOrderType() {
		return blockOrderType;
	}

	public String getQualifier() {
		return qualifier;
	}

	public void setBlockOrderType(String blockOrderType) {
		this.blockOrderType = blockOrderType;
	}

	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}
}