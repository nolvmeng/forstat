package com.haisan.saleOA.domain;

public class GoodItem {

	private Good good;
	private int amount;
	
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	//���췽��
	public GoodItem(Good good, int amount){
		this.good = good;
		this.amount = amount; 
	}
	
	
	
	
	//��ȡ�����ܶ�
	public float getItemMoney(){
		return good.getGoodPrice() * amount;
	}
	
	
}
