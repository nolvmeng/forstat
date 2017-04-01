package com.haisan.saleOA.service;

import java.util.List;

import com.haisan.saleOA.dao.impl.GoodDAOimpl;
import com.haisan.saleOA.domain.Good;

public class GoodService {
	

	GoodDAOimpl goodDAOimpl = new GoodDAOimpl();
	
	//��ȡ���еĻ�Ʒ
	public List<Good> getGoods(){
		List<Good> goods = goodDAOimpl.getAllGoods();
		return goods; 
	}
	
	//��ȡĳ���Ʒ
	public List<Good> getCaGoods(String category ){
		List<Good> goods = goodDAOimpl.getSameCa( category );
		return null;
	} 
	
	//��ȡĳ��Ʒ
	public Good getGood(String goodId ) {
	    Good good = goodDAOimpl.getGood(goodId);
		return good;
		  
	}
	
	//���ӻ�Ʒ
	
	//�޸Ļ�Ʒ
	
	//ɾ����Ʒ
	

}
