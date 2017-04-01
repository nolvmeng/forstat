package com.haisan.saleOA.test;

import java.sql.Date;
import java.util.List;

import com.haisan.saleOA.dao.impl.GoodDAOimpl;
import com.haisan.saleOA.domain.Good;


public class TestGoodDAOimpl {
	
	GoodDAOimpl GG = new GoodDAOimpl();	
		
	public void insertText(){

	/*	  String goodId ="1232";
		  String goodName="dd";
		  float goodPrice=1;
		  Date productDate = null ;
		  int reserve=1;
		  String category="shui";*/
		  
		  
		  Good good = GG.getGood("120");//getbook测试通过
			if(good!=null)good.setGoodId("12w89");
       		GG.addGood(good);
	 
	}//测试通过
	
	public void update(){
		Good good = GG.getGood("120");//getbook测试通过
		if(good!=null)good.setGoodName("heioan");
		GG.setGood(good);
		
		
	}//测试通过
	
	
	public void seCa(){
		List<Good> goods =  GG.getSameCa("shui");
		if (goods != null){
			System.out.println("sdh");
			for(Good good : goods){
				System.out.println(good.getGoodName());	
			}
		}
				
	}//测试通过
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		TestGoodDAOimpl test = new TestGoodDAOimpl();
		test.insertText();
	
	
}}
