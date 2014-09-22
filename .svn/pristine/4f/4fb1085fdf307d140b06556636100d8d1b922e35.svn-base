package com.sapient.equitytradingapp.pm.actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.pojo.Order;
import com.sapient.equitytradingapp.pm.pojo.Portfolio;
import com.sapient.equitytradingapp.pm.service.AmendService;
import com.sapient.equitytradingapp.pm.service.CreateOrderPrefillFieldsService;

/**
 * Call "Amend" service for chosen orders.
 */

@ParentPackage(value = "tiles-default")
@Action(value = "Amend", results = {
		@Result(location = "amend-view", type = "tiles", name = "success"),
		@Result(location = "view-order-blotter", type = "chain", name = "input") })
public class AmendAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	Order order;
	private List<Portfolio> portfolio;
	List<Long> checkboxes;
	String showMessage;

	@Autowired
	AmendService amendService;

	@Autowired
	CreateOrderPrefillFieldsService OrderPrefillLists;

	public String getShowMessage() {
		return showMessage;
	}

	public void setShowMessage(String showMessage) {
		this.showMessage = showMessage;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Portfolio> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(List<Portfolio> portfolio) {
		this.portfolio = portfolio;
	}

	public List<Long> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(List<Long> checkboxes) {
		this.checkboxes = checkboxes;
	}
	
	Map<String, Object> session = ActionContext.getContext().getSession();

	public String execute() {
		if (order == null) {
			showMessage = "This order cannot be amended";
			session.put("sessionMessage", new String(showMessage));
			return StringLiterals.INPUT;
		}
		return StringLiterals.SUCCESS;
	}

	@Override
	public void validate() {
		order = amendService.amendMethod(checkboxes.get(0));
		String manager = (String) ActionContext.getContext().getSession()
				.get("sessionUsername");
		portfolio = OrderPrefillLists.returnPortfolio(manager);
		showMessage = "Order successfully amended";
		if (order != null)
			if (order.getTotalQuantity() <= 0)
				showMessage = "Quantity must be greater than zero";
		session.put("sessionMessage", new String(showMessage));
	}
}
