package com.haisan.saleOA.dao;

import java.util.List;

import com.haisan.saleOA.domain.Order;

public interface OrderDAO {
	
	/**
	 *����orderId ��ȡorder����
	 * @param orderId������Id
	 * @return
	 **/
	public abstract Order getOrder(String orderId);
	
	/**
	 * ����һ��Order��������һ��Order
	 * @param Order: Order����
	 * @return int��1Ϊ���޸� 
	 **/
	public abstract int setOrder(Order order);
	
	
	/**
	 * ����һ��order
	 * @param order:Order����
	 * @return int
	 **/
	public abstract int addOrder(Order order);
	
	
	
	/**
	 * ��ȡ�����б�
	 * @param 
	 * @return List<Order> 
	 **/
    public abstract List<Order> getOrderList();
    
    
    /**
     * ��ȡ�����ܶ�
     * @param Order
     * @return float
     **/
    public abstract double getTotal(String orderId);
    
    
    
     
    
	
	

}
