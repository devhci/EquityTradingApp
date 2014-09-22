package com.sapient.equitytradingapp.et.interfaces;

import com.sapient.equitytradingapp.pm.pojo.Order;
/**
 * Interface for PM to amend an order
 * @author dkumar40
 *
 */
public interface AmendOrderInterface {
	/**
	 * 
	 * @param order of type Order
	 * @return Boolean
	 */
	public boolean amendOrder(Order order);

}
