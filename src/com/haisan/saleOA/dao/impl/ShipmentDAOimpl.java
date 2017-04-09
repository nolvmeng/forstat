package com.haisan.saleOA.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.haisan.saleOA.dao.ShipmentDAO;
import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.domain.GoodItem;
import com.haisan.saleOA.domain.Shipment;

public class ShipmentDAOimpl extends BaseDAO<Shipment> implements ShipmentDAO{

	@Override
	public int addShipment(Shipment shipment) { 
		String OId = shipment.getOrderId();
		String GId = shipment.getGoodId();
		int Amount = shipment.getAmount();
	  	String sql = "INSERT INTO shipment(orderId,goodId,amount) VALUES(?,?,?)";
        update(sql,OId, GId, Amount); 
		return 1;
	}//Âß¼­ÅÐ¶ÏÇ¨ÒÆµ½ServiceÖÐ

	@Override
	public Shipment getShipment(String orderId, String goodId) {
          String sql = "SELECT * FROM shipment WHERE orderId=? AND goodId=?";
          return query(sql, orderId, goodId); 
	}

	@Override
	public boolean updateItem(Shipment ship, int amount) {
		String sql = "UPDATE shipment SET amount=?  WHERE orderId=? AND goodId=?";
		update(sql, amount, ship.getOrderId(), ship.getGoodId());
		return true;
	}

	@Override
	public void saveBatch(List<Shipment> ship) {
          String sql ="INSERT INTO shipment(orderId,goodId,amount,prive) VALUES(?,?,?,?)";		
          Object [][] params = new Object[ship.size()][4];
  		
  		//List<GoodItem> goodsItems = new ArrayList<GoodItem>(goods);
  		for(int i = 0; i < ship.size(); i++){
  			params[i][0] = ship.get(i).getOrderId();
  			params[i][1] = ship.get(i).getGoodId();
  			params[i][2] = ship.get(i).getAmount();
  			params[i][3] = ship.get(i).getPrive();
   		}
  		
  		batch(sql, params);
	}

	@Override
	public List<String> getgetListGood(String orderId) {
		String sql = "SELECT goodId FROM shipment WHERE orderId=?";
		List<Shipment> list = queryForList(sql, orderId);
		List<String> GoodIdList = new ArrayList<String>();
		for(Shipment s :list){
			GoodIdList.add(s.getGoodId());
		} 
		return GoodIdList;
		
		
	}

}
