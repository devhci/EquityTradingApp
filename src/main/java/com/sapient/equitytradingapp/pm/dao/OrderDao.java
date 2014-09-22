package com.sapient.equitytradingapp.pm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.pm.constant.StringLiterals;
import com.sapient.equitytradingapp.pm.pojo.Order;

@Repository
public class OrderDao {
	private EntityManager manager;
	@Autowired
	BlockOrder blockOrder;

	public EntityManager getManager() {
		return manager;
	}

	@PersistenceContext
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * saves order passed to it in database
	 * 
	 * @param order
	 *            of type Order
	 */
	@Transactional
	public void createOrder(Order order) {
		order.setStatus(StringLiterals.NEW);
		manager.persist(order);
	}

	/**
	 * 
	 * @param orderId
	 */
	@Transactional
	public void sendOrder(int orderId) {

		String q = "update Order set status='sent' where orderId='" + orderId
				+ "'";
		Query query = manager.createQuery(q);
		query.executeUpdate();
	}

	/**
	 * cancels a order
	 * 
	 * @param orderId
	 */
	@Transactional
	public void cancelOrder(int orderId) {

		String q = "update Order set status='cancelled' where orderId='"
				+ orderId + "'";
		Query query = manager.createQuery(q);
		query.executeUpdate();
	}

	/**
	 * 
	 * @param orderBlotter
	 */
	@Transactional
	public void editOrder(Order orderBlotter) {
		Order ob = manager.find(Order.class, 3);
		String status = ob.getStatus();
		ob = orderBlotter;
		ob.setStatus(status);
		manager.merge(ob);
	}

	/**
	 * returns orders related to a particular trader where status of orders is
	 * "sent for execution"
	 * 
	 * @param trader
	 *            if type String
	 * @return List of Order
	 */
	@Transactional
	public List<Order> getOrdersForTrader(String trader) {
		TypedQuery<Order> query = manager
				.createQuery(
						"from Order o where o.trader = ? and o.status=? and o.blockOrderId is null order by o.symbol",
						Order.class);
		query.setParameter(1, trader);
		query.setParameter(2, StringLiterals.SENT);
		return query.getResultList();

	}

	public Order getOrderById(Long orderId) {
		return manager.find(Order.class, orderId);
	}

	/**
	 * returns list of possible BlockOrder which can be created by trader
	 * 
	 * @param trader
	 *            of type String
	 * @return List of BlockOrder
	 */
	@Transactional
	public List<BlockOrder> getProposedList(String trader) {

		Query query = manager
				.createQuery("select side,symbol,sum(totalQuantity) as totalQuantity, sum(allocatedQuantity) as executedQuantity, (totalQuantity-allocatedQuantity) as openQuantity, min(limitPrice) as limitPrice,max(stopPrice) as stopPrice,status,orderQualifier as qualifier,orderType as blockOrderType from Order where trader=? and status=? and side='buy' and blockOrderId is null group by side,symbol,orderQualifier,orderType");
		Query query1 = manager
				.createQuery("select side,symbol,sum(totalQuantity) as totalQuantity, sum(allocatedQuantity) as executedQuantity, (totalQuantity-allocatedQuantity) as openQuantity, max(limitPrice) as limitPrice,min(stopPrice) as stopPrice,status,orderQualifier as qualifier,orderType as blockOrderType from Order where trader=? and status=? and side='sell' and blockOrderId is null group by side,symbol,orderQualifier,orderType");

		query.setParameter(1, trader);
		query.setParameter(2, StringLiterals.SENT);
		query1.setParameter(1, trader);
		query1.setParameter(2, StringLiterals.SENT);
		List<Object[]> list = query.getResultList();
		List<Object[]> list1 = query1.getResultList();
		List<BlockOrder> proposedList = new ArrayList<BlockOrder>();
		BlockOrder tempOrder;

		for (Object[] result : list) {

			tempOrder = new BlockOrder();

			tempOrder.setSide((String) result[0]);
			tempOrder.setSymbol((String) result[1]);
			tempOrder.setTotalQuantity(Integer.parseInt(result[2].toString()));

			tempOrder
					.setExecutedQuantity(Integer.parseInt(result[3].toString()));
			tempOrder.setOpenQuantity(Integer.parseInt(result[4].toString()));
			tempOrder.setLimitPrice(Double.parseDouble(result[5].toString()));
			tempOrder.setStopPrice(Double.parseDouble(result[6].toString()));
			tempOrder.setStatus((String) result[7]);
			tempOrder.setQualifier((String) result[8]);
			tempOrder.setBlockOrderType((String) result[9]);
			tempOrder.setTrader(trader);
			proposedList.add(tempOrder);
			System.out.println(proposedList);
		}
		for (Object[] result1 : list1) {
			tempOrder = new BlockOrder();

			tempOrder.setSide((String) result1[0]);
			tempOrder.setSymbol((String) result1[1]);
			tempOrder.setTotalQuantity(Integer.parseInt(result1[2].toString()));

			tempOrder.setExecutedQuantity(Integer.parseInt(result1[3]
					.toString()));
			tempOrder.setOpenQuantity(Integer.parseInt(result1[4].toString()));
			tempOrder.setLimitPrice(Double.parseDouble(result1[5].toString()));
			tempOrder.setStopPrice(Double.parseDouble(result1[6].toString()));
			tempOrder.setStatus((String) result1[7]);
			tempOrder.setQualifier((String) result1[8]);
			tempOrder.setBlockOrderType((String) result1[9]);
			tempOrder.setTrader(trader);
			proposedList.add(tempOrder);

		}

		return proposedList;

	}

	/**
	 * updates a Order to passed in database
	 * 
	 * @param order
	 *            of type Order
	 */
	@Transactional
	public void saveUpdatedOrder(Order order) {
		manager.merge(order);
	}

	public List<Order> getOrderForSideAndSymbol(String side, String symbol,
			String trader, String qualifier, String blockOrderType) {
		TypedQuery<Order> query = manager
				.createQuery(
						"from Order o where o.symbol =? and o.side = ? and o.trader = ? and o.status=? and o.orderQualifier=? and o.orderType=? and o.blockOrderId is null",
						Order.class);
		query.setParameter(1, symbol);
		query.setParameter(2, side);
		query.setParameter(3, trader);
		query.setParameter(4, StringLiterals.SENT);
		query.setParameter(5, qualifier);
		query.setParameter(6, blockOrderType);
		return query.getResultList();
	}
}
