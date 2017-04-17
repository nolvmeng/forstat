package com.haisan.saleOA.dao;

import java.sql.Date;
import java.util.List;

import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.web.Page;


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
     *@return List<Good>
     **/
    public abstract List<Good> getAllGoods();
    
    
    /**
     * 获取某页货品列表
     *@param int : start起始
     *@param int : pageSize每页条目数
     *@return Page<Good>
     **/
    public abstract List<Good> getPageGood(int start, int pageSize);
     
    
    /**
     * 获取条目数
     *@return int: 数目
     **/
     public abstract int getTotalGoodNumber();	
     
     
     /**
      * 获取该种类货品数目
      *@param String: category
      *@return int: 数目
      **/
    public abstract int getCaTotal(String category);


     /**
      * 按种类分表获取该类货品列表
      *@param int: 开始
      *@param int: 每页条目数
      *@param String: category种类
      *@return page<Good>
      **/
    
    public abstract List<Good> getCaPageGood(int start, int end, String category);

    
    /**
     * 修改goodId
     *@param String:oldId 旧的 goodId
     *@param String:newId 新的 goodId
     **/
    public abstract void updateId(String oldId, String newId);
    
    
    /**
     * 删除某货品
     *@param String:goodId
     * @return 
     **/
    public abstract void delGood(String goodId);
    
    
   

}
