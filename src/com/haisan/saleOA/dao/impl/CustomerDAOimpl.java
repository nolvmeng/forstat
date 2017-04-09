package com.haisan.saleOA.dao.impl;

import java.util.List;

import com.haisan.saleOA.dao.CustomerDAO;
import com.haisan.saleOA.domain.Customer;
import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.web.Page;

public class CustomerDAOimpl extends BaseDAO<Customer> implements CustomerDAO  {

	@Override
	public Customer getCustomer(String customerId) { 
		String sql = "SELECT customerId, customerName, address, phoneNum FROM customers WHERE customerId=?";
		return query(sql, customerId);
	}

	@Override
	public int addCustomer(Customer cus) {
		String sql = "INSERT INTO customers(customerId, customerName, address, phoneNum ) VALUES(?,?,?,?)";
		 update(sql, cus.getCustomerId(), cus.getCustomerName(), cus.getAddress(), cus.getPhoneNum());
		return 0;
		
	}
 

	@Override
	public int setCustomer(Customer cus) {
		String sql = "UPDATE customers SET customerId=?, customerName=?,address=?,PhoneNum=? WHERE customerId=?";
		update(sql, cus.getCustomerId(), cus.getCustomerName(), cus.getAddress(),cus.getPhoneNum(),cus.getCustomerId()); 
		return 0;
		 
	}

	@Override
	public List<Customer> getCuCa() {
		String sql = "SELECT * FROM customers ";
		return  queryForList(sql);
	}

	@Override
	public int getTotalNum() {
		String sql = "SELECT count(customerId) FROM customers";
		long num = getSingleVal(sql);
		int n = (int)num;
		return n;
		
	}

	@Override
	public   List<Customer> getCusList(int start, int pageSize) {
		
		String sql = "SELECT * FROM customers ORDER BY customerId ASC LIMIT ? ,?"; 
		return queryForList(sql,  start, pageSize);
		
	}

	@Override
	public String getId(String name) {
		String sql = "SELECT customerId FROM customers where customerName = ?";
		Customer id = query(sql,name);
		return id.getCustomerId();
	}
     
	
	
	
}
