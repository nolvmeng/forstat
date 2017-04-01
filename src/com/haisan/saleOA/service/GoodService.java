package com.haisan.saleOA.service;

import java.util.List;

import com.haisan.saleOA.dao.impl.GoodDAOimpl;
import com.haisan.saleOA.domain.Good;

public class GoodService {
	

	GoodDAOimpl goodDAOimpl = new GoodDAOimpl();
	
	//获取所有的货品
	public List<Good> getGoods(){
		List<Good> goods = goodDAOimpl.getAllGoods();
		return goods; 
	}
	
	//获取某类货品
	public List<Good> getCaGoods(String category ){
		List<Good> goods = goodDAOimpl.getSameCa( category );
		return null;
	} 
	
	//获取某货品
	public Good getGood(String goodId ) {
	    Good good = goodDAOimpl.getGood(goodId);
		return good;
		  
	}
	
	//增加货品
	
	//修改货品
	
	//删除货品
	

}
