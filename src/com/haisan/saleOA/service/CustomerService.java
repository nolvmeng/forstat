package com.haisan.saleOA.service;

import com.haisan.saleOA.dao.impl.CustomerDAOimpl;
import com.haisan.saleOA.domain.Customer;
import com.haisan.saleOA.web.Page;

public class CustomerService {
	  CustomerDAOimpl cusDAO = new CustomerDAOimpl();  
	
	//获取客户表
   public Page<Customer> getPageCus(int pageNO, int pageSize){
	   Page<Customer> pageCus = new Page<Customer>(pageNO);
	   pageCus.setPageSize(pageSize);
	   pageCus.setPageNO(pageNO);
	   pageCus.setTotalItemNumber(cusDAO.getTotalNum());
	   int start = (pageCus.getPageNO()-1)*pageCus.getPageSize();
	   int end = pageCus.getPageSize();
	   pageCus.setList(cusDAO.getCusList(start, end));
	   return pageCus;
   }
   
 //添加账户
  	public Customer addCustomer(Customer cus){
  		cusDAO.addCustomer(cus);
 		return cus;
          		//返回新建的用户，用于反馈是否创建
  	}
	

}
