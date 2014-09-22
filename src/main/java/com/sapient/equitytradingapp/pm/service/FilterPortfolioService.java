package com.sapient.equitytradingapp.pm.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.sapient.equitytradingapp.pm.actions.LoginAction;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.pojo.ViewPosition;
import com.sapient.equitytradingapp.pm.pojo.ViewSecurity;

/**
 * To retrieve filtered portfolio details as passed to service.
 * 
 */
@Component
public class FilterPortfolioService {

	private static Logger logger = Logger.getLogger(LoginAction.class);
	List<ViewPosition> viewPositionList;

	public List<ViewPosition> getViewPositionList() {
		return viewPositionList;
	}

	public void setViewPositionList(List<ViewPosition> viewPositionList) {
		this.viewPositionList = viewPositionList;
	}

	@Autowired
	ViewPositionService viewPositionService;
	
	@Autowired
	ViewPositionFromOrdersService viewPositionFromOrdersService;

	/**
	 * Return filtered portfolio details
	 * 
	 * @param filterChoice
	 *            of type String
	 * @param filterValue
	 *            of type String
	 * @return
	 */
	public List<ViewPosition> filterDisplay(String filterChoice,
			String filterValue) {
		logger.info("inside filterDisplay method of FilterPortfolio class");
		List<ViewPosition> filterViewPositionList = new ArrayList<ViewPosition>();
		String username = (String) ActionContext.getContext().getSession()
				.get("sessionUsername");
		//viewPositionList = viewPositionService.displayPositions(username);
		viewPositionList=viewPositionFromOrdersService.getPositionDetails(username);
		viewPositionList=viewPositionFromOrdersService. removeOrderWithZeroQuantity(viewPositionList);
		if (filterChoice.equals(StringLiterals.PORTFOLIO_NAME)) {
			for (ViewPosition v : viewPositionList) {
				if ((v.getPortfolioName()).equalsIgnoreCase(filterValue)) {
					filterViewPositionList.add(v);
				}
			}

		} else if (filterChoice.equals(StringLiterals.SECURITY_SYMBOL)) {
			int flag = 0;
			for (ViewPosition v : viewPositionList) {
				ViewPosition newViewPosition = new ViewPosition();
				newViewPosition.setAccountName(v.getAccountName());
				newViewPosition.setPortfolioName(v.getPortfolioName());
				List<ViewSecurity> sList = v.getSecurityList();
				List<ViewSecurity> newViewSecurityList = new ArrayList<ViewSecurity>();
				flag = 0;
				for (ViewSecurity s : sList) {
					if ((s.getSymbol()).equalsIgnoreCase(filterValue)) {
						newViewSecurityList.add(s);
						flag = 1;
					}
				}
				if (flag == 1) {
					newViewPosition.setSecurityList(newViewSecurityList);
					filterViewPositionList.add(newViewPosition);
				}

			}
		} else if (filterChoice.equals(StringLiterals.ACCOUNT_NAME)) {
			for (ViewPosition v : viewPositionList) {
				if ((v.getAccountName()).equalsIgnoreCase(filterValue)) {
					filterViewPositionList.add(v);
				}
			}
		}

		return filterViewPositionList;

	}

}
