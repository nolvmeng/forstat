package com.haisan.saleOA.service;

import java.util.List;

import com.haisan.saleOA.dao.impl.CustomerDAOimpl;
import com.haisan.saleOA.domain.Customer;
import com.haisan.saleOA.web.Page;

public class CustomerService {
	  CustomerDAOimpl cusDAO = new CustomerDAOimpl();  
	
	//��ȡ�ͻ���
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
   
 //����˻�
  	public Customer addCustomer(Customer cus){
  		cusDAO.addCustomer(cus);
 		return cus;
          		//�����½����û������ڷ����Ƿ񴴽�
  	}

  //��ȡ�ͻ���
  	public List<Customer> getCuCa(){
  		List<Customer> cus=cusDAO.getCuCa();
  		return cus;
  	}

  	//���ݿͻ�����ȡ�ͻ�Id
  	public String getId(String name){
  		return cusDAO.getId(name);
  	}

}
