package com.sapient.equitytradingapp.et.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.equitytradingapp.et.pojo.BlockOrder;
import com.sapient.equitytradingapp.pm.pojo.Order;

/**
 * 
 * @author dkumar40 this class interacts with block_order table of mock_database
 */
@Repository
public class BlockOrderDAO {

	private static Logger logger = Logger.getLogger(BlockOrderDAO.class);
	EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	/**
	 * returns list of BlockOrder created by a particular trader
	 * @param trader of type String
	 * @return List of BlockOrder
	 */
	public List<BlockOrder> getDetails(String trader) {

		Query q = entityManager
				.createQuery("Select b from BlockOrder b where b.trader =? and b.status!=?");
		q.setParameter(1, trader);
		q.setParameter(2, "Sent for Execution");
		@SuppressWarnings("unchecked")
		List<BlockOrder> list = q.getResultList();
		logger.info("Block Order Details fetched");
		return list;
	}

	/**
	 * saves a new BlockOrder in database
	 * @param blockOrder of type BlockOrder
	 * @return void
	 */
	public void save(BlockOrder blockOrder) {
		entityManager.persist(blockOrder);
	}

	/**
	 * updates BlockOrder passed in database
	 * @param blockOrder of type BlockOrder
	 * @return void
	 */
	@Transactional
	public void updateBlockOrder(BlockOrder blockOrder) {
		entityManager.merge(blockOrder);
	}

	/**
	 * removes a BlockOrder from database
	 * 
	 * @param blockOrderof type BlockOrder
	 *            
	 * @return
	 */
	@Transactional
	public void deleteDetails(BlockOrder blockOrder) {
		BlockOrder block = getBlockOrderById(blockOrder.getBlockOrderId());
		entityManager.remove(block);
	}

	/**
	 * 
	 * @param id  of type Long
	 *           
	 * @return a List of Order
	 */
	public List<Order> getOrderDetails(long id) {

		TypedQuery<Order> query = entityManager.createQuery(
				"from Order o where blockOrderId=?", Order.class);
		query.setParameter(1, id);
		List<Order> list = query.getResultList();
		return list;
	}

	/**
	 * saves the passed BlockOrder into database and assigns its Id to list of orders passed.
	 * @param blockOrder of type BlockOrder
	 * @param orderList of type List of Orders
	 */
	@Transactional
	public void createNewBlockOrder(BlockOrder blockOrder, List<Order> orderList) {
		entityManager.persist(blockOrder);
		for (Order order : orderList) {
			order.setBlockOrderId(blockOrder.getBlockOrderId());
			entityManager.merge(order);
		}

	}

	public BlockOrder getBlockOrderById(Integer blockOrderId) {

		return entityManager.find(BlockOrder.class, blockOrderId);
	}

	public BlockOrder getBlockOrderById(Long blockOrderId) {

		return entityManager.find(BlockOrder.class, blockOrderId);

	}

	/**
	 * To save edited block order in database
	 * @param blockId  of type Long 
	 * @param ltPrice of type double
	 * @param stopPrice of type double
	 *            
	 */
	@Transactional
	public void persistEdit(Long blockId, double ltPrice, double stopPrice) {

		BlockOrder blOrder = entityManager.find(BlockOrder.class, blockId);
		blOrder.setLimitPrice(ltPrice);
		blOrder.setStopPrice(stopPrice);
		entityManager.persist(blOrder);

	}

	/**
	 * returns list of Order whose fields match parameters passed
	 * @param side of type String
	 * @param symbol of type String
	 * @param trader of type String 
	 * @param qualifier of type String
	 * @param blockOrderType of type String
	 * @return list of block orders : List<BlockOrder>
	 */
	public List<BlockOrder> getCorrespondingBlocks(String side, String symbol,
			String trader,String qualifier,String blockOrderType) {

		TypedQuery<BlockOrder> query = entityManager
				.createQuery(
						"from BlockOrder bo where bo.side = ? and bo.symbol=? and bo.trader=? and bo.status=? " +
						"and bo.qualifier=? and bo.blockOrderType=?",
						BlockOrder.class);
		query.setParameter(1, side);
		query.setParameter(2, symbol);
		query.setParameter(3, trader);
		query.setParameter(4, "new");
		query.setParameter(5, qualifier);
		query.setParameter(6, blockOrderType);
		return query.getResultList();
	}

	/**
	 * cancels a block order
	 * @param blockOrderList
	 */
	@Transactional
	public void cancelBlockOrder(List<BlockOrder> blockOrderList) {
		for (BlockOrder b : blockOrderList) {
			Query query = entityManager
					.createQuery("update Order set blockOrderId=null where blockOrderId=?");
			query.setParameter(1, b.getBlockOrderId());
			query.executeUpdate();

		}

	}

	/**
	 * removes order passed from their block Orders
	 * @param orderList
	 *            of type List<Order>
	 */
	@Transactional
	public void removeOrdersFromBlockOrder(List<Order> orderList) {
		for (Order o : orderList) {
			Query query = entityManager
					.createQuery("update Order set blockOrderId=null where blockOrderId=? and orderId=?");
			query.setParameter(1, o.getBlockOrderId());
			query.setParameter(2, o.getOrderId());
			query.executeUpdate();

			Query query1 = entityManager
					.createQuery("update BlockOrder set totalQuantity=totalQuantity-?,executedQuantity=executedQuantity-?,openQuantity=openQuantity-? where blockOrderId=?");
			query1.setParameter(1, o.getTotalQuantity());
			query1.setParameter(2, o.getAllocatedQuantity());
			query1.setParameter(3, o.getTotalQuantity()-o.getAllocatedQuantity());
			query1.setParameter(4, o.getBlockOrderId());
			query1.executeUpdate();
		}
		if (orderList.get(0).getSide().equalsIgnoreCase("buy")) {
			Query query7 = entityManager
					.createQuery("update BlockOrder set limitPrice=(select min(limitPrice) from Order where blockOrderId=?), stopPrice=(select max(stopPrice) from Order where blockOrderId=?) where blockOrderId=?");
			query7.setParameter(1, orderList.get(0).getBlockOrderId());
			query7.setParameter(2, orderList.get(0).getBlockOrderId());
			query7.setParameter(3, orderList.get(0).getBlockOrderId());
			query7.executeUpdate();
		} else if (orderList.get(0).getSide().equalsIgnoreCase("sell")) {
			Query query7 = entityManager
					.createQuery("update BlockOrder set limitPrice=(select max(limitPrice) from Order where blockOrderId=?), stopPrice=(select min(stopPrice) from Order where blockOrderId=?) where blockOrderId=?");
			query7.setParameter(1, orderList.get(0).getBlockOrderId());
			query7.setParameter(2, orderList.get(0).getBlockOrderId());
			query7.setParameter(3, orderList.get(0).getBlockOrderId());
			query7.executeUpdate();
		}
		Query query1 = entityManager
				.createQuery("select count(orderId) from Order where blockOrderId=?");
		query1.setParameter(1, orderList.get(0).getBlockOrderId());
		Integer count = Integer.parseInt(query1.getSingleResult().toString());
		
		if (count == 0)
		{
			Query query2 = entityManager
					.createQuery("select b from BlockOrder b where blockOrderId=?");
			query2.setParameter(1, orderList.get(0).getBlockOrderId());

			BlockOrder blockOrder = (BlockOrder) query2.getSingleResult();
			deleteDetails(blockOrder);
		}
			

	}
   /**
    * returns list of orders corresponding to BlockOrder passed
    * @param blockOrderId of type Long
    * @return
    */
	public List<Order> getSortedOrderDetails(Long blockOrderId) {
		TypedQuery<Order> query=entityManager.createQuery("from Order where blockOrderId=? and status!=? order by orderId asc",Order.class);
		query.setParameter(1, blockOrderId);
		query.setParameter(2, "Completed");
		return query.getResultList();
	}

}
