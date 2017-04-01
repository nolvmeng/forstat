package com.haisan.saleOA.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Order {
	
	private String orderId;
	private String customerId;
	private Date orderDate;
	private String userId;
	private String delivery;//�Ƿ����
	
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getOrderDate() {
		/*//�������ڸ�ʽ����ʽΪ��yyyy-MM-dd  
		SimpleDateFormat  SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		//��ʽ����ǰ����  
		SimpleDateFormat.format(orderDate); */
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
		
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId
				+ ", orderDate=" + orderDate + ", userId=" + userId
				+ ", delivery=" + delivery + "]";
	}
	
	


}
