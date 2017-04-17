package com.haisan.saleOA.dao.impl;

import java.util.List;

import com.haisan.saleOA.dao.OrderDAO;
import com.haisan.saleOA.domain.Order;

public class OrderDAOimpl extends BaseDAO<Order> implements OrderDAO{

	@Override
	public Order getOrder(String orderId) {
		String sql = "SELECT orderId, customerId, orderDate, userId, delivery FROM orders WHERE orderId= ? ";
        return query(sql, orderId); 
		
	}

	@Override
	public int setOrder(Order order) {
		String sql = "UPDATE orders SET orderId= ?, customerId=?, orderDate=?, userId=?, delivery=? WHERE orderId = ?";
		System.out.println(sql);
		update(sql, order.getOrderId(), order.getCustomerId(), order.getOrderDate(), order.getUserId(),
				order.getDelivery(),order.getOrderId());
		return 0;
		
	}

	@Override
	public int addOrder(Order order) {
		String sql = "INSERT INTO orders(orderId, customerId, orderDate, userId, delivery) VALUES (?,?,?,?,?)";
		update(sql, order.getOrderId(), order.getCustomerId(), order.getOrderDate(), order.getUserId(), order.getDelivery());
		return 0;
		
	}

	@Override
	public List<Order> getOrderList(int start, int pageSize) {
		String sql = "SELECT * FROM orders ORDER BY orderId ASC LIMIT ? ,?"; 
		return queryForList(sql, start, pageSize);
		
	}

	@Override
	public double getTotal(String orderId) {
		String sql = "SELECT sum(goodPrice*amount ) FROM orders,shipment,goods "
				+ "WHERE orders.orderId = shipment.orderId AND shipment.goodId= goods.goodId AND orders.orderId=?"
				+ "GROUP BY orders.orderId";
		
		return getSingleVal(sql, orderId);
		
	}
	@Override
	public int getTotalNum(String userId) {
		String sql = "SELECT count(orderId) FROM orders WHERE userId=?";
		long num = getSingleVal(sql, userId);
		int n = (int)num;
		return n;
		
	}

	@Override
	public int getTotalNum() {
		
		String sql = "SELECT count(orderId) FROM orders  ";
		long num = getSingleVal(sql);
		int n = (int)num;
		return n;
		
	}

	@Override
	public List<Order> getOrderList(int start, int pageSize, String userId) {
		String sql = "SELECT * FROM orders WHERE userId=? ORDER BY orderId ASC LIMIT ? ,?"; 
		return queryForList(sql, userId, start, pageSize);
	}

	@Override
	public void delOrder(String orderId) {
		String sql="DELETE FROM orders WHERE orderId=? ";
		update(sql, orderId);
		
	}

	@Override
	public void delOrdership(String orderId) {
		String sql="DELETE FROM shipment WHERE orderId=? ";
		update(sql, orderId);
		
	}

	@Override
	public String getLastOrderId() {
		String sql = "SELECT MAX(orderId) FROM orders ORDER BY orderId ASC ";
		return getSingleVal(sql);
		
	}

	@Override
	public List<Order> getsomeOrder(int start, int pageSize, String userId,String orderkey) {
		String sql = "SELECT orderId, orders.customerId, orderDate, userId, delivery FROM orders,customers"
				+ " WHERE userId=? and orders.customerId=customers.customerId AND concat(orderId,customerName,orderDate,userId,delivery)  LIKE ?"
				+ " ORDER BY orderId ASC LIMIT ?,?";
		String sql2="%"+orderkey+"%";
        return queryForList(sql,userId,sql2,start,pageSize);
	}

	@Override
	public List<Order> getsomeOrder(int start, int pageSize, String orderkey) {
		String sql = "SELECT orderId, orders.customerId, orderDate, userId, delivery FROM orders,customers"
				+ " WHERE orders.customerId=customers.customerId AND concat(orderId,customerName,orderDate,userId,delivery)  LIKE ?"
				+ " ORDER BY orderId ASC LIMIT ?,?";
		String sql2="%"+orderkey+"%";
        return queryForList(sql, sql2,start,pageSize);
		
	}

	
	
}
