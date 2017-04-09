package com.haisan.saleOA.dao;

import java.util.List;

import com.haisan.saleOA.domain.Customer;
import com.haisan.saleOA.web.Page;

public interface CustomerDAO {

	/**
	 * ����customerId��ȡһ��Customer����
	 * @ param customerId:Stirng
	 * @ return Customer
	 **/
    public abstract  Customer getCustomer(String customerId);
    
    
    /**
     * ����һ��Customer��¼
     * @param customer
     * return int 1Ϊ�ɹ�
     **/
    public abstract int addCustomer(Customer customer);
    
    /**
     * �޸�customer��¼
     * **/
    public abstract int setCustomer(Customer customer);
    
    /**
     * ��ȡcustomer���м�¼
     **/
    public abstract List<Customer> getCuCa();
    
    
    /**
     * ��ȡ�ͻ���Ŀ 
     * @return int : ��Ŀ
     **/
    public abstract int getTotalNum();
    
    
    /**
     * �ݱ��ѯ��ȡ�ͻ�List
     *@param int : start
     *@param int : end
     *@return Page<Customer>: �û��б�
     **/
    public abstract List<Customer> getCusList(int start, int pageSize);
    
    /**
     * ���ݿͻ�����ȡ�ͻ�Id
     *@param String : �ͻ���
     *@return String: �ͻ�Id 
     **/
    public abstract String getId(String name);
    
    
}
