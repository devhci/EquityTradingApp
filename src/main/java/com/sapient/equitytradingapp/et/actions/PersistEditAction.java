package com.sapient.equitytradingapp.et.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.sapient.equitytradingapp.et.dao.BlockOrderDAO;
import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;

@ParentPackage("tiles-default")
@Action(value = "editPersist")
@Results({
		@Result(name = "success", location = "BlockOrderBlotter", type = "chain"),
		@Result(location = "Error.jsp", name = "exception") })
public class PersistEditAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Long blockOrderId;

	public Long getBlockOrderId() {
		return blockOrderId;
	}

	public void setBlockOrderId(Long blockOrderId) {
		this.blockOrderId = blockOrderId;
	}

	private double limitPrice;
	private double stopPrice;

	@Autowired
	BlockOrderDAO blockOrderDAO;

	public double getStopPrice() {
		return stopPrice;
	}

	public double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}

	public void setStopPrice(double stopPrice) {
		this.stopPrice = stopPrice;
	}

	private BlockOrder editBlock;

	public BlockOrder getEditBlock() {
		return editBlock;
	}

	public void setEditBlock(BlockOrder editBlock) {
		this.editBlock = editBlock;
	}

	public String execute() {
		try {
			blockOrderDAO.persistEdit(blockOrderId, limitPrice, stopPrice);
			System.out.println(stopPrice + limitPrice);
			return "success";

		} catch (Exception e) {
			return StringLiterals.EXCEPTION;
		}
	}

}
