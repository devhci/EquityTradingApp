package com.sapient.equitytradingapp.et.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proposed_block_order")
public class ProposedBlockOrder {
	@Id
	@Column(name = "block_id")
	private long blockId;
	@Column
	private String side;
	@Column
	private String symbol;
	@Column
	private String trader;
	@Column(name = "limit_price")
	private double limitPrice;
	@Column(name = "stop_price")
	private double stopPrice;
	@Column(name = "total_quantity")
	private int totalQuantity;
	@Column(name = "open_quantity")
	private int openQuantity;
	@Column(name="block_order_type")
	private String blockOrderType;
	@Column
	private String qualifier;

	public long getBlockId() {
		return blockId;
	}

	public void setBlockId(long blockId) {
		this.blockId = blockId;
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

	public String getTrader() {
		return trader;
	}

	public void setTrader(String trader) {
		this.trader = trader;
	}

	public double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}

	public double getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(double stopPrice) {
		this.stopPrice = stopPrice;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getOpenQuantity() {
		return openQuantity;
	}

	public void setOpenQuantity(int openQuantity) {
		this.openQuantity = openQuantity;
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
