package com.haisan.saleOA.dao;

import java.util.List;

import com.haisan.saleOA.domain.Customer;
import com.haisan.saleOA.web.Page;

public interface CustomerDAO {

	/**
	 * 根据customerId获取一个Customer对象
	 * @ param customerId:Stirng
	 * @ return Customer
	 **/
    public abstract  Customer getCustomer(String customerId);
    
    
    /**
     * 新增一条Customer记录
     * @param customer
     * return int 1为成功
     **/
    public abstract int addCustomer(Customer customer);
    
    /**
     * 修改customer记录
     * **/
    public abstract int setCustomer(Customer customer);
    
    /**
     * 获取customer所有记录
     **/
    public abstract List<Customer> getCuCa();
    
    
    /**
     * 获取客户数目 
     * @return int : 数目
     **/
    public abstract int getTotalNum();
    
    
    /**
     * 份表查询获取客户List
     *@param int : start
     *@param int : end
     *@return Page<Customer>: 用户列表
     **/
    public abstract List<Customer> getCusList(int start, int pageSize);
    
    /**
     * 根据客户名获取客户Id
     *@param String : 客户名
     *@return String: 客户Id 
     **/
    public abstract String getId(String name);
    
    
}
