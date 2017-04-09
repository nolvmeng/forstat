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
    public abstract List<Order> getOrderList(int start, int pageSize);
    
    
    /**
     * ��ȡ�����ܶ�
     * @param Order
     * @return float
     **/
    public abstract double getTotal(String orderId);
    
    
    /**
     * ��ȡ��Ŀ��
     * @param String : userId
     * @return int: ��Ŀ��
     **/
    public abstract int getTotalNum(String userId);
    
    
    
    /**
     * ��ȡ��Ŀ��
     * @return int: ��Ŀ��
     **/
    public abstract int getTotalNum();
    
    
    /**
     * �ֱ��ѯ����ȡList<Order>
     * @param int : start
     * @param int : pageSize
     * @param String : userId
     * @return list<Order> :�����б�
     **/
    public abstract List<Order> getOrderList(int start, int pageSize, String userId);
    
    
    /**
     * ɾ��ĳ����
     *@param String:goodId
     * @return 
     **/
    public abstract void delOrder(String orderId);
    
    
    /**
     * ɾ��ĳ����
     *@param String:goodId
     * @return 
     **/
    public abstract void delOrdership(String orderId);
    
    /**
     * ��ȡ���һ��������
     *@return String :orderId
     **/
    public abstract String getLastOrderId();
    
    
     
    
	
	

}
