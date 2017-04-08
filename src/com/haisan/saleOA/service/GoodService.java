package com.haisan.saleOA.service;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.haisan.saleOA.dao.impl.GoodDAOimpl;
import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.web.Page;

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
	
	//
	public List<Good> getListGood(List<String> goodId){
		List<Good> goods = new ArrayList<Good>() ;
		for(String s : goodId){
			goods.add(goodDAOimpl.getGood(s));
		}
		return goods;
	}
	
	
	//添加货品
	 public Good addGood(Good good){
		 goodDAOimpl.addGood(good);
		return good;
		 
	 }
	
/*	//获取某页货品，每页记录暂定为10条
	public Page<Good> getPageGood(int pageNO ){
		List<Good> goods = goodDAOimpl.getAllGoods();
		Page<Good> PGood = new Page<Good>(pageNO);
 		PGood.setPageSize(10);
 		PGood.setTotalItemNumber(goods.size());
 		PGood.setList(goods.subList((pageNO-1)*10, PGood.getPageNO()*10));
 		return PGood;
	}
*/	
	
	public Page<Good> getPageGood(int pageNO, int pageSize, String category){
		Page<Good> PGood = new Page<Good>(pageNO);
		PGood.setPageSize(pageSize);
		PGood.setPageNO(pageNO);//或可无
		int end = PGood.getPageSize();
		if(category.equals("all")){
		     PGood.setTotalItemNumber(goodDAOimpl.getTotalGoodNumber());
		     int start = (PGood.getPageNO()-1)*PGood.getPageSize();
		     PGood.setList(goodDAOimpl.getPageGood(start, end));
		    System.out.println(PGood.getPageNO()); System.out.println("pageNO");
		}
		else{//按种类分表查询
			PGood.setTotalItemNumber(goodDAOimpl.getCaTotal(category));
			int start = (PGood.getPageNO()-1)*PGood.getPageSize();
			PGood.setList(goodDAOimpl.getCaPageGood(start, end, category));
		}
		return PGood;
	} 
	
	 
	
	
	
	//增加货品
	
	//修改货品
	
	//删除货品
	

}
