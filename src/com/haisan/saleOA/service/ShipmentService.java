package com.haisan.saleOA.service;

import java.util.List;

import com.haisan.saleOA.dao.ShipmentDAO;
import com.haisan.saleOA.dao.impl.ShipmentDAOimpl;
import com.haisan.saleOA.domain.GoodItem;
import com.haisan.saleOA.domain.Shipment;

public class ShipmentService {

	ShipmentDAO shipmentDAO = new ShipmentDAOimpl();
	
	//����һ��shipment��¼
	public boolean addItem(Shipment shipment){
		String OId = shipment.getOrderId();
		String GId = shipment.getGoodId();
		int Amount = shipment.getAmount();
		Shipment Ship =shipmentDAO.getShipment(OId, GId);
		if(Ship != null){//�ж��Ƿ��Ѿ����ڸ������������amount����������
			Amount += Ship.getAmount();
			shipmentDAO.updateItem(shipment, Amount);
		}
		else
			shipmentDAO.addShipment(shipment);
		return true;
		
	}
	
	//��������shipment��¼
	public boolean addBatch(List<GoodItem> items, String orderId){
		/*boolean isSu = false;*/
		items = onlyList(items);
		shipmentDAO.saveBatch(items, orderId);  
		return true;
	}
	
	//����Items�б��ܽ��
	public double sumItems(List<GoodItem> items){
		double sum = 0.0;
		for(GoodItem goodItem: items){
			sum += goodItem.getItemMoney();
		}
		return sum;
	}
	
	
	//ȥ�ط���,ȥ����ͬgoodId�ģ���amount�ۼ�
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
