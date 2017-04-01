package com.haisan.saleOA.service;

import java.util.List;

import com.haisan.saleOA.dao.ShipmentDAO;
import com.haisan.saleOA.dao.impl.ShipmentDAOimpl;
import com.haisan.saleOA.domain.GoodItem;
import com.haisan.saleOA.domain.Shipment;

public class ShipmentService {

	ShipmentDAO shipmentDAO = new ShipmentDAOimpl();
	
	//新增一条shipment记录
	public boolean addItem(Shipment shipment){
		String OId = shipment.getOrderId();
		String GId = shipment.getGoodId();
		int Amount = shipment.getAmount();
		Shipment Ship =shipmentDAO.getShipment(OId, GId);
		if(Ship != null){//判断是否已经存在该项，如存在则更新amount，否则新增
			Amount += Ship.getAmount();
			shipmentDAO.updateItem(shipment, Amount);
		}
		else
			shipmentDAO.addShipment(shipment);
		return true;
		
	}
	
	//批量增加shipment记录
	public boolean addBatch(List<GoodItem> items, String orderId){
		/*boolean isSu = false;*/
		items = onlyList(items);
		shipmentDAO.saveBatch(items, orderId);  
		return true;
	}
	
	//计算Items列表总金额
	public double sumItems(List<GoodItem> items){
		double sum = 0.0;
		for(GoodItem goodItem: items){
			sum += goodItem.getItemMoney();
		}
		return sum;
	}
	
	
	//去重方法,去除相同goodId的，将amount累加
    public List<GoodItem> onlyList(List<GoodItem> item){
    	//List<GoodItem> only =new ArrayList<GoodItem>() ;    	
    	int newAmount = 0;
    	for(int i=0; i<item.size(); i++){
    		newAmount =item.get(i).getAmount();
    		for(int j=i+1; j<item.size(); j++){
    			if(item.get(i).getGood().getGoodId().equals(item.get(j).getGood().getGoodId())){
    				newAmount +=item.get(j).getAmount();
    				item.remove(j);
    				j--;
    			}
    		}
    		item.get(i).setAmount(newAmount);
    		
    	}
    	return item;
    }
	
	
	
  }
