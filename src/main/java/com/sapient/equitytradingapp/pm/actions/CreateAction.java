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
import com.sapient.equitytradingapp.pm.pojo.Security;
import com.sapient.equitytradingapp.pm.pojo.User;
import com.sapient.equitytradingapp.pm.service.CreateOrderPrefillFieldsService;
import com.sapient.equitytradingapp.pm.service.CreateOrderService;

/**
 * Call Create Order Service
 * 
 */
@ParentPackage(value = "tiles-default")
@Action(value = "/create", results = {
		@Result(location = "pm/passToOrderBlotterAction.jsp", name = "success"),
		@Result(location = "create-view", type = "tiles", name = "input") })
public class CreateAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Security> security;
	private List<User> trader;
	private List<Portfolio> portfolio;
	String showMessage;

	@Autowired
	CreateOrderPrefillFieldsService createOrderPrefillLists;

	public String getShowMessage() {
		return showMessage;
	}

	public void setShowMessage(String showMessage) {
		this.showMessage = showMessage;
	}

	public List<Security> getSecurity() {
		return security;
	}

	public void setSecurity(List<Security> security) {
		this.security = security;
	}

	public List<User> getTrader() {
		return trader;
	}

	public void setTrader(List<User> trader) {
		this.trader = trader;
	}

	public List<Portfolio> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(List<Portfolio> portfolio) {
		this.portfolio = portfolio;
	}

	@Autowired
	Order order;

	@Autowired
	CreateOrderService orderService;
	
	Map<String, Object> session = ActionContext.getContext().getSession();

	// @VisitorFieldValidator
	public void setOrder(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public String execute() {
		if (orderService.addorderservice(order).equalsIgnoreCase("success")){
			showMessage = "Order successfully created.";
			session.put("sessionMessage", showMessage);
			return StringLiterals.SUCCESS;
		}	
		return StringLiterals.INPUT;
	}

	@Override
	public void validate() {
		String manager = (String) ActionContext.getContext().getSession()
				.get("sessionUsername");
		// searchSymbol = createOrderPrefillLists.returnSecurity();
		security = createOrderPrefillLists.returnSecurity();
		trader = createOrderPrefillLists.returnTrader();
		portfolio = createOrderPrefillLists.returnPortfolio(manager);

		if (getOrder().getOrderType().equalsIgnoreCase(
				StringLiterals.MARKETORDER)) {

			if (getOrder().getLimitPrice() != 0
					|| getOrder().getStopPrice() != 0) {

				addActionError("Limit Price and Stop Price must be null for Market Order");
			}
		}
		if (getOrder().getOrderType().equalsIgnoreCase(
				StringLiterals.LIMITORDER)) {
			if (getOrder().getLimitPrice() == 0
					|| getOrder().getStopPrice() != 0) {
				addActionError("In case of Order Type:-LIMIT order, Stop Price must be zero and Limit Price can not be zero");

			}

		}

		if (getOrder().getOrderType()
				.equalsIgnoreCase(StringLiterals.STOPORDER)) {

			if (getOrder().getLimitPrice() != 0
					|| getOrder().getStopPrice() == 0) {
				addActionError("In case of Order Type:-Stop Order, Limit Price must be zero and Stop Price can not be zero");

			}

		}
		
		
		String side=getOrder().getSide();
		
		
		if(side.equalsIgnoreCase("BUY")&& getOrder().getOrderType().equalsIgnoreCase(StringLiterals.STOPLIMITORDER)){
			
			if(order.getLimitPrice()>order.getStopPrice()){
				
				addActionError("In case of Stop Limit Order and side Buy ,the stop price should be greater than limit price ");
			}
		}
			
			else {
				if(side.equalsIgnoreCase("SELL")&& getOrder().getOrderType().equalsIgnoreCase(StringLiterals.STOPLIMITORDER)){
					
					addActionError("In case of Stop Limit Order and side Sell ,the limit price should be greater than stop price ");
					
					
					
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

				addActionError("Limit Price and Stop Price cannot be null for STOP LIMIT Order");
			}

		}

	}

}
