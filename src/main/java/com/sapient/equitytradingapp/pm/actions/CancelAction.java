package com.sapient.equitytradingapp.pm.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.service.CancelOrderService;

/**
 * Call "Cancel" service for chosen orders.
 */
@Action(value = "Cancel", results = { @Result(location = "view-order-blotter", type = "chain") })
public class CancelAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	CancelOrderService cancelOrderService;
	List<Long> checkboxes;

	String showMessage;

	public List<Long> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(List<Long> checkboxes) {
		this.checkboxes = checkboxes;
	}

	public String execute() {

		String status = cancelOrderService.cancelOrder(checkboxes.get(0));
		if (status.equalsIgnoreCase(StringLiterals.CANCELLED))
			showMessage = "Order successfully cancelled";
		else if (status.equalsIgnoreCase(StringLiterals.COMPLETED))
			showMessage = "The completed order cannot be cancelled";
		else
			showMessage = "The order sent to Broker cannot be cancelled";
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("sessionMessage", new String(showMessage));
	
		return StringLiterals.SUCCESS;
	}


}
