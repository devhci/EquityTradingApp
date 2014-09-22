package com.sapient.equitytradingapp.pm.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.pojo.Portfolio;
import com.sapient.equitytradingapp.pm.pojo.Security;
import com.sapient.equitytradingapp.pm.pojo.User;
import com.sapient.equitytradingapp.pm.service.CreateOrderPrefillFieldsService;

@ParentPackage(value = "tiles-default")
@Action(value = "create-order-prefill", results = {
		@Result(location = "create-view", type = "tiles", name = "success"),
		@Result(location = "Error.jsp", name = "exception") })
public class CreateOrderPrefillFieldsAction {

	@Autowired
	CreateOrderPrefillFieldsService createOrderPrefillService;

	List<User> trader;
	List<Portfolio> portfolio;
	List<Security> security;

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

	public List<Security> getSecurity() {
		return security;
	}

	public void setSecurity(List<Security> security) {
		this.security = security;
	}

	public String execute() {
		try {

			String manager = (String) ActionContext.getContext().getSession()
					.get("sessionUsername");
			trader = createOrderPrefillService.returnTrader();
			portfolio = createOrderPrefillService.returnPortfolio(manager);
			security = createOrderPrefillService.returnSecurity();

			return StringLiterals.SUCCESS;
		} catch (Exception e) {
			return StringLiterals.EXCEPTION;
		}
	}

}
