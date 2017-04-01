package com.haisan.saleOA.dao;

import java.util.List;

import com.haisan.saleOA.domain.Customer;

public interface CustomerDAO {

	/**
	 * ����customerId��ȡһ��Customer����
	 * @ param customerId:Stirng
	 * @ return Customer
	 **/
    public Customer getCustomer(String customerId);
    
    
    /**
     * ����һ��Customer��¼
     * @param customer
     * return int 1Ϊ�ɹ�
     **/
    public int addCustomer(Customer customer);
    
    /**
     * �޸�customer��¼
     * **/
    public int setCustomer(Customer customer);
    
    /**
     * ��ȡcustomer���м�¼
     **/
    public List<Customer> getCuCa();
}
