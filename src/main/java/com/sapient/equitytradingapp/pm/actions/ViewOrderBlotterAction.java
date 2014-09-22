package com.sapient.equitytradingapp.pm.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.pojo.Order;
import com.sapient.equitytradingapp.pm.service.ViewOrderBlotterService;

@ParentPackage(value = "tiles-default")
@Action(value = "view-order-blotter", results = { @Result(location = "orderBlotter-view", type = "tiles", name = "success"), })
public class ViewOrderBlotterAction {

	List<Order> orderList;
	String showMessage;

	public String getShowMessage() {
		return showMessage;
	}

	public void setShowMessage(String showMessage) {
		this.showMessage = showMessage;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	@Autowired
	ViewOrderBlotterService viewOrderBlotterService;

	public String execute() {
		String manager = (String) ActionContext.getContext().getSession()
				.get("sessionUsername");
		orderList = viewOrderBlotterService.getOrders(manager);

		showMessage = (String) ActionContext.getContext().getSession()
				.get("sessionMessage");
		return StringLiterals.SUCCESS;
	}
}
