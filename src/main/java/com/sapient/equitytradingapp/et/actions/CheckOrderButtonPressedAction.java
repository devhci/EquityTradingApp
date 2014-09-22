package com.sapient.equitytradingapp.et.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.sapient.equitytradingapp.pm.constant.StringLiterals;

/**
 * <b>Class to Pass Order Values for Adding or Removing Orders from a Block</b>
 * 
 * @author dkumar40
 * 
 */
@Action(value = "CheckOrderButtonPressed")
@Results({
		@Result(name = "addMoreOrders", location = "OrderBlotter1", type = "chain"),
		@Result(name = "removeOrders", location = "RemoveOrdersFromBlockOrder", type = "chain"),
		@Result(name = "input", location = "orders", type = "chain"),
		@Result(name = "input1", location = "ViewBlockOrder", type = "chain"),
		@Result(location = "Error.jsp", name = "exception")})
public class CheckOrderButtonPressedAction {
	private String buttonName;
	List<Long> orderIdList;

	public String execute() {
		try {
			// condition to pass value to respective action
			if (buttonName.equals("Add More Orders"))
				return "addMoreOrders";
			else if (buttonName.equals("Remove Orders")) {
				if (orderIdList == null||orderIdList.size()==0) {
					HttpServletRequest request = ServletActionContext.getRequest();
					request.setAttribute("message1",
							"You must choose at least 1 order to remove");
					return "input1";
				}
				return "removeOrders";
			} else
				return StringLiterals.INPUT;
			
		} catch (Exception e) {
			return StringLiterals.EXCEPTION;
		}
	}

	public List<Long> getOrderIdList() {
		return orderIdList;
	}

	public void setOrderIdList(List<Long> orderIdList) {
		this.orderIdList = orderIdList;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

}
