package com.sapient.equitytradingapp.et.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.sapient.equitytradingapp.et.service.RemoveOrdersFromBlockOrderService;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;

/**
 * This class is used to remove specified orders from the Block Order
 * 
 * @author dkumar40
 * 
 */
@ParentPackage("tiles-default")
@Action(value = "RemoveOrdersFromBlockOrder")
@Results({
		@Result(name = "success", location = "ViewBlockOrder", type = "chain"),
		@Result(location = "Error.jsp", name = "exception") })
public class RemoveOrdersFromBlockOrderAction {

	@Autowired
	private RemoveOrdersFromBlockOrderService removeOrderService;

	List<Long> orderIdList;

	public List<Long> getOrderIdList() {
		return orderIdList;
	}

	public void setOrderIdList(List<Long> orderIdList) {
		this.orderIdList = orderIdList;
	}

	public String execute() {
		try {
			Map<String, Object> session = ActionContext.getContext()
					.getSession();
			session.put("removeOrders", "true");
			removeOrderService.removeOrderFromBlock(orderIdList);
			return "success";

		} catch (Exception e) {
			return StringLiterals.EXCEPTION;
		}

	}

}
