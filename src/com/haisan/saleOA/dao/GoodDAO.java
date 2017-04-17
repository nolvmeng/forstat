package com.haisan.saleOA.dao;

import java.sql.Date;
import java.util.List;

import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.web.Page;


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
     *@return List<Good>
     **/
    public abstract List<Good> getAllGoods();
    
    
    /**
     * ��ȡĳҳ��Ʒ�б�
     *@param int : start��ʼ
     *@param int : pageSizeÿҳ��Ŀ��
     *@return Page<Good>
     **/
    public abstract List<Good> getPageGood(int start, int pageSize);
     
    
    /**
     * ��ȡ��Ŀ��
     *@return int: ��Ŀ
     **/
     public abstract int getTotalGoodNumber();	
     
     
     /**
      * ��ȡ�������Ʒ��Ŀ
      *@param String: category
      *@return int: ��Ŀ
      **/
    public abstract int getCaTotal(String category);


     /**
      * ������ֱ��ȡ�����Ʒ�б�
      *@param int: ��ʼ
      *@param int: ÿҳ��Ŀ��
      *@param String: category����
      *@return page<Good>
      **/
    
    public abstract List<Good> getCaPageGood(int start, int end, String category);

    
    /**
     * �޸�goodId
     *@param String:oldId �ɵ� goodId
     *@param String:newId �µ� goodId
     **/
    public abstract void updateId(String oldId, String newId);
    
    
    /**
     * ɾ��ĳ��Ʒ
     *@param String:goodId
     * @return 
     **/
    public abstract void delGood(String goodId);
    
    
   

}
