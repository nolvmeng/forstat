package com.haisan.saleOA.dao;

import java.util.List;

import com.haisan.saleOA.domain.Order;

public interface OrderDAO {
	
	/**
	 *根据orderId 获取order对象
	 * @param orderId：订单Id
	 * @return
	 **/
	public abstract Order getOrder(String orderId);
	
	/**
	 * 根据一个Order对象设置一个Order
	 * @param Order: Order对象
	 * @return int：1为已修改 
	 **/
	public abstract int setOrder(Order order);
	
	
	/**
	 * 增加一个order
	 * @param order:Order对象
	 * @return int
	 **/
	public abstract int addOrder(Order order);
	
	
	
	/**
	 * 获取订单列表
	 * @param 
	 * @return List<Order> 
	 **/
    public abstract List<Order> getOrderList(int start, int pageSize);
    
    
    /**
     * 获取订单总额
     * @param Order
     * @return float
     **/
    public abstract double getTotal(String orderId);
    
    
    /**
     * 获取条目数
     * @param String : userId
     * @return int: 条目数
     **/
    public abstract int getTotalNum(String userId);
    
    
    
    /**
     * 获取条目数
     * @return int: 条目数
     **/
    public abstract int getTotalNum();
    
    
    /**
     * 分表查询，获取List<Order>
     * @param int : start
     * @param int : pageSize
     * @param String : userId
     * @return list<Order> :订单列表
     **/
    public abstract List<Order> getOrderList(int start, int pageSize, String userId);
    
    
    /**
     * 删除某订单
     *@param String:goodId
     * @return 
     **/
    public abstract void delOrder(String orderId);
    
    
    /**
     * 删除某订单
     *@param String:goodId
     * @return 
     **/
    public abstract void delOrdership(String orderId);
    
    /**
     * 获取最后一条订单号
     *@return String :orderId
     **/
    public abstract String getLastOrderId();
    
    
     
    
	
	

}
