package com.haisan.saleOA.dao;

import java.util.List;

import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.domain.GoodItem;
import com.haisan.saleOA.domain.Shipment;

public interface ShipmentDAO {
	
	/**
	 * ����һ����¼,��ͬorderId��ͬgoodId״̬ʱ����amount
	 * @param Shipment
	 * return int 1Ϊ�ɹ�
	 **/
	public abstract int addShipment(Shipment shipment);

   /**
    * ��ȡһ����¼Ϊһ��Shipment����
    * @param orderId
    * @param goodId
    * return shipment
    **/
	public abstract Shipment getShipment(String orderId, String goodId );
	
	
	/**
	 * ����shipment��amount����
	 * @param shipment
	 * @param amount int 
	 * @return boolean
	 **/
	public abstract boolean updateItem(Shipment shipment, int amount);
	 
	/**
	 * ����goods��������chipment��¼
	 * @param List<GoodItem> 
	 * @param String orderId ������
	 **/
	public abstract void saveBatch(List<GoodItem> goods, String orderId);
	
	
	/**
	 * ���ݶ�����orderId��ȡ��ƷId List
	 * @param String : orderId
	 * @return List<String> 
	 **/
	public abstract List<String> getgetListGood(String orderId);
	
	
	
	
	
	
	
	
	
	
	
}
