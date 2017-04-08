package com.haisan.saleOA.test;

import java.util.List;

import com.haisan.saleOA.dao.impl.OrderDAOimpl;
import com.haisan.saleOA.domain.Order;

public class TestOrderDAO {

	OrderDAOimpl OO = new OrderDAOimpl();
	
	public void  test1(){
		Order re = OO.getOrder("23");
		System.out.println(re.getOrderDate());
	}//����ͨ��
	
	public void test2(){
		Order re = OO.getOrder("12");
		re.setCustomerId("1s1");
		OO.setOrder(re);
		System.out.println(re.getCustomerId());
		
	}//����ͨ��
	
	public void test3(){
		Order re = OO.getOrder("123");
		re.setOrderId("21323");
		re.setDelivery("YES");
		OO.addOrder(re);
		System.out.println(re.toString());		
	}//����ͨ��
	
	/*public void test4(){
		List<Order> orderList = OO.getOrderList();
		for(Order o: orderList){
			System.out.println(o.toString());
		}
		
	}//����ͨ��
*/	
	
	 public  void test5(){
		 double total  = OO.getTotal("12");
		 System.out.println(total);
	 }//����ͨ��
	
	
	public static void main(String[] args) {
            TestOrderDAO aa = new TestOrderDAO();
            aa.test5();
            
            
    
		
		
	}

}
