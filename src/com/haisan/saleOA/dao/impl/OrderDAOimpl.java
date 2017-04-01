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
	public List<Order> getOrderList() {
		String sql = "SELECT orderId, customerId, orderDate, userId, delivery FROM orders  ";
		List<Order> orderList = queryForList(sql);
		return orderList;
		
	}

	@Override
	public double getTotal(String orderId) {
		String sql = "SELECT sum(goodPrice*amount ) FROM orders,shipment,goods "
				+ "WHERE orders.orderId = shipment.orderId AND shipment.goodId= goods.goodId AND orders.orderId=?";
		
		return getSingleVal(sql, orderId);
		
	}

	
	
}
