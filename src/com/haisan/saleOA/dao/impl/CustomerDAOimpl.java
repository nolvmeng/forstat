package com.haisan.saleOA.dao.impl;

import java.util.List;

import com.haisan.saleOA.dao.CustomerDAO;
import com.haisan.saleOA.domain.Customer;

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
     
	
	
	
}
