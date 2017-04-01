package com.haisan.saleOA.dao;

import java.util.List;

import com.haisan.saleOA.domain.Customer;

public interface CustomerDAO {

	/**
	 * 根据customerId获取一个Customer对象
	 * @ param customerId:Stirng
	 * @ return Customer
	 **/
    public Customer getCustomer(String customerId);
    
    
    /**
     * 新增一条Customer记录
     * @param customer
     * return int 1为成功
     **/
    public int addCustomer(Customer customer);
    
    /**
     * 修改customer记录
     * **/
    public int setCustomer(Customer customer);
    
    /**
     * 获取customer所有记录
     **/
    public List<Customer> getCuCa();
}
