package com.haisan.saleOA.dao;

import java.sql.Date;
import java.util.List;

import com.haisan.saleOA.domain.Good;


public interface GoodDAO {

	/**
	 *根据goodId获取good对象
	 * @param goodId：货品ID
	 * @return
	 **/
	public abstract Good getGood(String goodId);
	
	
	/**
	 * 通过一个good设置good对象
	 * @param Good:一个Good对象
	 * @return
	 **/
	public abstract int setGood(Good good);
	
	
	/**
	 *通过一个good对象新增good
	 * @param good
	 * @return
	 **/
	public abstract int addGood(Good good );
	
	/**
	*根据good的category属性获取相同属性good列表
	*@param category:为单种
	*@return List<Good>
	**/
    public abstract List<Good> getSameCa(String categery); 	
    
    
    
    /**
     * 获取全部货品
     * return List<Good>
     **/
    public abstract List<Good> getAllGoods();
    
    
    
    
    
	
}
