
package com.sapient.equitytradingapp.et.jms;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@XmlRootElement
@Entity
@Component
public class Transactions {


	@Id
	@GeneratedValue
	private int transactionid;
	@Column
	private int blockorderid;
	@Column
	private int tradeexecutionid;
	@Column
	private int tradequantity;
	@Column
	private float tradeprice;
	@Column
	private Date transactiontime;
	@Column
	private String username;
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public int getBlockorderid() {
		return blockorderid;
	}
	public void setBlockorderid(int blockorderid) {
		this.blockorderid = blockorderid;
	}
	public int getTradeexecutionid() {
		return tradeexecutionid;
	}
	public void setTradeexecutionid(int tradeexecutionid) {
		this.tradeexecutionid = tradeexecutionid;
	}
	public int getTradequantity() {
		return tradequantity;
	}
	public void setTradequantity(int tradequantity) {
		this.tradequantity = tradequantity;
	}
	public float getTradeprice() {
		return tradeprice;
	}
	public void setTradeprice(float tradeprice) {
		this.tradeprice = tradeprice;
	}
	public Date getTransactiontime() {
		return transactiontime;
	}
	public void setTransactiontime(Date transactiontime) {
		this.transactiontime = transactiontime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transactions(int blockorderid, int tradeexecutionid,
			int tradequantity, float tradeprice, Date transactiontime,
			String username) {
		super();
		this.blockorderid = blockorderid;
		this.tradeexecutionid = tradeexecutionid;
		this.tradequantity = tradequantity;
		this.tradeprice = tradeprice;
		this.transactiontime = transactiontime;
		this.username = username;
	}
	
	
	
	
	
}
