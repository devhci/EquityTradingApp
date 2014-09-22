package com.sapient.equitytradingapp.pm.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.pojo.ViewPosition;
import com.sapient.equitytradingapp.pm.service.FilterPortfolioService;
import com.sapient.equitytradingapp.pm.service.ViewPositionFromOrdersService;
import com.sapient.equitytradingapp.pm.service.ViewPositionService;

@ParentPackage(value = "tiles-default")
@Action(value = "filter-portfolio", results = {
		@Result(location = "layout-view", type = "tiles", name = "success"),
		@Result(location = "layout-view", type = "tiles", name = "input") })
public class FilterPortfolioAction {

	String filterChoice;
	String filterValue;
	List<ViewPosition> viewPositionList;

	public List<ViewPosition> getViewPositionList() {
		return viewPositionList;
	}

	public void setViewPositionList(List<ViewPosition> viewPositionList) {
		this.viewPositionList = viewPositionList;
	}

	public String getFilterChoice() {
		return filterChoice;
	}

	public void setFilterChoice(String filterChoice) {
		this.filterChoice = filterChoice;
	}

	public String getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

	@Autowired
	FilterPortfolioService filterPortfolioService;

	@Autowired
	ViewPositionService viewPositionService;

	@Autowired
	ViewPositionFromOrdersService viewPositionFromOrdersService;
	public String execute() {
		if (filterChoice.equals(StringLiterals.ANY)) {
			String username = (String) ActionContext.getContext().getSession()
					.get("sessionUsername");
			//viewPositionList = viewPositionService.displayPositions(username);
			viewPositionList=viewPositionFromOrdersService.getPositionDetails(username);
			viewPositionList=viewPositionFromOrdersService. removeOrderWithZeroQuantity(viewPositionList);
		}

		else if (filterChoice.equals(StringLiterals.PORTFOLIO_NAME) || filterChoice.equals(StringLiterals.ACCOUNT_NAME) || filterChoice.equals(StringLiterals.SECURITY_SYMBOL)) 
			viewPositionList = filterPortfolioService.filterDisplay(
					filterChoice, filterValue);
		else{
			String username = (String) ActionContext.getContext().getSession()
					.get("sessionUsername");
			viewPositionList=viewPositionFromOrdersService.getPositionDetails(username);
			viewPositionList=viewPositionFromOrdersService. removeOrderWithZeroQuantity(viewPositionList);
		}
			
		return StringLiterals.SUCCESS;
	}
}
