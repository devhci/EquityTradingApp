package com.sapient.equitytradingapp.pm.actions;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
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

@ParentPackage(value = "tiles-default")
@Action(value = "/amend_change", results = {
		@Result(location = "view-order-blotter", type = "chain", name = "success"),
		@Result(location = "amend-view", type = "tiles", name = "input") })
public class AmendChangeAction extends ActionSupport {

	/**
	 * Call "Amend" interface of ET for chosen getOrders to persist the change.
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	Order order;
	String showMessage;
	private List<Portfolio> portfolio;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getShowMessage() {
		return showMessage;
	}

	public void setShowMessage(String showMessage) {
		this.showMessage = showMessage;
	}


	public List<Portfolio> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(List<Portfolio> portfolio) {
		this.portfolio = portfolio;
	}

	@Autowired
	private AmendService amendService;

	@Autowired
	CreateOrderPrefillFieldsService getOrderPrefillLists;

	Map<String, Object> session = ActionContext.getContext().getSession();

	public String execute() {

		if (amendService.changeValues(order)) {
			/*showMessage = "Order successfully amended";
			session.put("sessionMessage", new String(showMessage));*/
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("message",
					"Order successfully amended mohit");
			return "success";
		}
	/*	showMessage = "This getOrder cannot be amended";
		session.put("sessionMessage", new String(showMessage));*/
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("message",
				"This Order cannot be amended mohit");
		return "input";
	}

	@Override
	public void validate() {
		String manager = (String) ActionContext.getContext().getSession()
				.get("sessionUsername");
		portfolio = getOrderPrefillLists.returnPortfolio(manager);
		
		if (getOrder().getOrderType().equalsIgnoreCase(
				StringLiterals.MARKETORDER)) {

			if (getOrder().getLimitPrice() != 0
					|| getOrder().getStopPrice() != 0) {

				addActionError("Limit Price and Stop Price must be null for Market getOrder");
			}
		}
		if (getOrder().getOrderType().equalsIgnoreCase(
				StringLiterals.LIMITORDER)) {
			if (getOrder().getLimitPrice() == 0
					|| getOrder().getStopPrice() != 0) {
				addActionError("In case of getOrder Type:-LIMIT getOrder, Stop Price must be zero and Limit Price can not be zero");

			}

		}

		if (getOrder().getOrderType()
				.equalsIgnoreCase(StringLiterals.STOPORDER)) {

			if (getOrder().getLimitPrice() != 0
					|| getOrder().getStopPrice() == 0) {
				addActionError("In case of getOrder Type:-Stop getOrder, Limit Price must be zero and Stop Price can not be zero");

			}

		}

		String side = getOrder().getSide();

		if (side.equalsIgnoreCase("BUY")
				&& getOrder().getOrderType().equalsIgnoreCase(
						StringLiterals.STOPLIMITORDER)) {

			if (order.getLimitPrice() > order.getStopPrice()) {

				addActionError("In case of Stop Limit getOrder and side Buy ,the stop price should be greater than limit price ");
			}
		}

		else {
			if (side.equalsIgnoreCase("SELL")
					&& getOrder().getOrderType().equalsIgnoreCase(
							StringLiterals.STOPLIMITORDER)) {

				addActionError("In case of Stop Limit getOrder and side Sell ,the limit price should be greater than stop price ");

			}

		}

		if (getOrder().getPortfolioName().equalsIgnoreCase("1")) {

			addActionError("Please select portfolio");

		}

		if (getOrder().getTotalQuantity() <= 0) {

			addActionError("Quantity must be greater than zero");
		}

		if (getOrder().getOrderType().equalsIgnoreCase(
				StringLiterals.STOPLIMITORDER)) {

			if (getOrder().getLimitPrice() == 0
					|| getOrder().getStopPrice() == 0) {

				addActionError("Limit Price and Stop Price cannot be null for STOP LIMIT getOrder");
			}

		}

	}
}
