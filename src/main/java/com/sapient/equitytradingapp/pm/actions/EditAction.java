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
import com.sapient.equitytradingapp.pm.pojo.User;
import com.sapient.equitytradingapp.pm.service.CreateOrderPrefillFieldsService;
import com.sapient.equitytradingapp.pm.service.EditService;

/*import com.opensymphony.xwork2.ActionContext;*/

@ParentPackage(value = "tiles-default")
@Action(value = "Edit", results = {
		@Result(location = "edit-view", type = "tiles", name = "success"),
		@Result(location = "view-order-blotter", type = "chain", name="input") })
public class EditAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Autowired
	private EditService editService;
	Order order;
	private List<User> trader;
	private List<Portfolio> portfolio;
	List<Long> checkboxes;
	private String showMessage;

	public String getShowMessage() {
		return showMessage;
	}

	public void setShowMessage(String showMessage) {
		this.showMessage = showMessage;
	}
	@Autowired
	CreateOrderPrefillFieldsService OrderPrefillLists;

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

	public List<Long> getCheckboxes() {
		return checkboxes;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setCheckboxes(List<Long> checkboxes) {
		this.checkboxes = checkboxes;
	}
	
	
	public String execute() {

		if (order == null){
			showMessage = "Only new orders can be edited.";
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("sessionMessage", new String(showMessage));
			return StringLiterals.INPUT;
			
		}
		return StringLiterals.SUCCESS;
	}

	@Override
	public void validate() {
		//order from database
		
		order = editService.editOrder(checkboxes.get(0));
		
		String manager = (String) ActionContext.getContext().getSession()
				.get("sessionUsername");
		trader = OrderPrefillLists.returnTrader();
		portfolio = OrderPrefillLists.returnPortfolio(manager);
		
	}
}
