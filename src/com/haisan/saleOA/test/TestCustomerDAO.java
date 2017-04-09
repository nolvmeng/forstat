package com.haisan.saleOA.test;

import java.util.List;

import com.haisan.saleOA.dao.CustomerDAO;
import com.haisan.saleOA.dao.impl.CustomerDAOimpl;
import com.haisan.saleOA.domain.Customer;

public class TestCustomerDAO {
	       
	CustomerDAO CC = new CustomerDAOimpl();
            
     public void test1(){
    	 Customer customer = CC.getCustomer("4567");
    	 System.out.println(customer.getAddress());
     }//测试通过
     
     public void test2(){
    	 Customer customer = CC.getCustomer("4567");
    	 customer.setCustomerId("120390");
    	 CC.addCustomer(customer);
     }//测试通过
	 
     public void test3(){
    	 Customer customer = CC.getCustomer("4567");
    	 customer.setCustomerName("110110");
    	 CC.setCustomer(customer);
     }//tongguo
     
     public void test4(){
    	List<Customer> ListCus = CC.getCuCa();
    	for(Customer c : ListCus){
    		System.out.println(c.getCustomerName());
    	}
     }//测试通过 
	public static void main(String[] args) {
		
		TestCustomerDAO i = new TestCustomerDAO();	
		i.test4();
		
	
	}
	
	
}
