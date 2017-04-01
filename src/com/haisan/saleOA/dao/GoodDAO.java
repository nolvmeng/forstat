package com.haisan.saleOA.dao;

import java.sql.Date;
import java.util.List;

import com.haisan.saleOA.domain.Good;


public interface GoodDAO {

	/**
	 *����goodId��ȡgood����
	 * @param goodId����ƷID
	 * @return
	 **/
	public abstract Good getGood(String goodId);
	
	
	/**
	 * ͨ��һ��good����good����
	 * @param Good:һ��Good����
	 * @return
	 **/
	public abstract int setGood(Good good);
	
	
	/**
	 *ͨ��һ��good��������good
	 * @param good
	 * @return
	 **/
	public abstract int addGood(Good good );
	
	/**
	*����good��category���Ի�ȡ��ͬ����good�б�
	*@param category:Ϊ����
	*@return List<Good>
	**/
    public abstract List<Good> getSameCa(String categery); 	
    
    
    
    /**
     * ��ȡȫ����Ʒ
     * return List<Good>
     **/
    public abstract List<Good> getAllGoods();
    
    
    
    
    
	
}
