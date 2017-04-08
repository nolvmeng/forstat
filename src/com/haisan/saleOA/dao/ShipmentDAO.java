package com.haisan.saleOA.dao;

import java.util.List;

import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.domain.GoodItem;
import com.haisan.saleOA.domain.Shipment;

public interface ShipmentDAO {
	
	/**
	 * 新增一条记录,相同orderId，同goodId状态时更新amount
	 * @param Shipment
	 * return int 1为成功
	 **/
	public abstract int addShipment(Shipment shipment);

   /**
    * 获取一条记录为一个Shipment对象
    * @param orderId
    * @param goodId
    * return shipment
    **/
	public abstract Shipment getShipment(String orderId, String goodId );
	
	
	/**
	 * 更新shipment的amount数量
	 * @param shipment
	 * @param amount int 
	 * @return boolean
	 **/
	public abstract boolean updateItem(Shipment shipment, int amount);
	 
	/**
	 * 根据goods批量插入chipment记录
	 * @param List<GoodItem> 
	 * @param String orderId 订单号
	 **/
	public abstract void saveBatch(List<GoodItem> goods, String orderId);
	
	
	/**
	 * 根据订单号orderId获取货品Id List
	 * @param String : orderId
	 * @return List<String> 
	 **/
	public abstract List<String> getgetListGood(String orderId);
	
	
	
	
	
	
	
	
	
	
	
}
