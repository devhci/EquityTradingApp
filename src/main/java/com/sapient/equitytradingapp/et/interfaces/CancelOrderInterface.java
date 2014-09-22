package com.sapient.equitytradingapp.et.interfaces;
/**
 * Interface for PM to cancel an order
 * @author dkumar40
 *
 */
public interface CancelOrderInterface {
	/**
	 * 
	 * @param orderId of type Long
	 * @return Boolean
	 */
	public boolean cancelOrder(long orderId);
}
