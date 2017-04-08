package com.haisan.saleOA.domain;

import java.text.DecimalFormat;
import java.util.List;

/*
 * ��װ��������
 * */


public class OrderItem {
	
      private List<GoodItem> goodList; //������Ʒ�б�
      private String userId ;  //��������Ա��� 
      private Customer customer ; //�����ͻ�
      private double totalPrice;//�ܽ��
      private Order order;
      
      
      
      
      public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
      
    public List<GoodItem> getGoodList() {
		return goodList;
	}
	public void setGoodList(List<GoodItem> goodList) {
		this.goodList = goodList;
	}
	public double getTotalPrice() {
		double money  = 0.0 ;
		for(GoodItem item : goodList) {
			money += item.getItemMoney();
			
		}
		//DecimalFormat    df   = new DecimalFormat("######0.00");  
		//df.format(money);
		return money;
	}
	public String getTatalPriceS() {
		double money  = 0.0 ;
		for(GoodItem item : goodList) {
			money += item.getItemMoney();
			
		}
		DecimalFormat    df   = new DecimalFormat("######0.00");  
	
		return 	df.format(money);
	}
	
	
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	  
	  
	
	
	
}
