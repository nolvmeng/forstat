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
	}//�߼��ж�Ǩ�Ƶ�Service��

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
	public void saveBatch(List<GoodItem> goods, String orderId) {
          String sql ="INSERT INTO shipment(orderId,goodId,amount) VALUES(?,?,?)";		
          Object [][] params = new Object[goods.size()][3];
  		
  		//List<GoodItem> goodsItems = new ArrayList<GoodItem>(goods);
  		for(int i = 0; i < goods.size(); i++){
  			params[i][0] = orderId;
  			params[i][1] = goods.get(i).getGood().getGoodId();
  			params[i][2] = goods.get(i).getAmount(); 
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
