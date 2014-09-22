package com.sapient.equitytradingapp.pm.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.equitytradingapp.et.interfaces.AmendOrderInterface;
import com.sapient.equitytradingapp.pm.actions.LoginAction;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.dao.AmendDAO;
import com.sapient.equitytradingapp.pm.pojo.Order;

/**
 * Call Amend DAO to check order of status and amend order for which check
 * status is passed.
 */

@Component
public class AmendService {
	private static Logger logger = Logger.getLogger(LoginAction.class);

	@Autowired
	AmendDAO amendDAO;
	Order order;
	@Autowired
	AmendOrderInterface amendOrdersEtService;
	@Autowired
	AmendDAO amendOrderDAO;

	/**
	 * Call Amend DAO methods to check order of status and amend,retrieve order
	 * for which check status is passed.
	 * 
	 * @param orderId
	 *            of type long
	 * @return Order
	 */
	public Order amendMethod(long orderId) {

		logger.info("Inside amendMethod of AmendService class");
		String status = amendDAO.checkOrderStatusInDB(orderId);
		if (status.equalsIgnoreCase(StringLiterals.SENT))
			order = amendOrderDAO.retrieveFromDB(orderId);
		else
			order = null;
		return order;
	}

	public Boolean changeValues(Order order1) {
		if (amendOrdersEtService.amendOrder(order1))
			return true;
		else
			return false;
	}

}
