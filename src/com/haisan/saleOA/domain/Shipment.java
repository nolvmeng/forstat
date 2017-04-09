package com.haisan.saleOA.domain;

import java.text.DecimalFormat;

public class Shipment {
	
	private String orderId ;
	private String goodId ;
	private int amount;
	private float prive;//���µ������յ�ǰ�۸񣬳�Ϊ�ö�������ʱ�ļ۸񣬲��ܺ�����Ʒ�۸�ı��Ӱ��

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public float getPrive() {
		return prive;
	}
	public void setPrive(float price) {
		this.prive = price;
	}
	
	
	public float getTotalPrice(){
		return getPrive()*getAmount();
	}
	
	public String getTotalPriceS(){
		DecimalFormat    df   = new DecimalFormat("######0.00");
		
		return df.format(getPrive()*getAmount());  
	}
}
