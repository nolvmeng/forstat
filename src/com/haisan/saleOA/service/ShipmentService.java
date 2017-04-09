package com.haisan.saleOA.service;

import java.util.ArrayList;
import java.util.List;

import com.haisan.saleOA.dao.ShipmentDAO;
import com.haisan.saleOA.dao.impl.ShipmentDAOimpl;
import com.haisan.saleOA.domain.Good;
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
	public boolean addBatch(List<Shipment> ship){
		/*boolean isSu = false;*/
		//items = onlyList(items);//��ȡ��ȥ��
		shipmentDAO.saveBatch(ship);  
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
    				item.remove(j);//�Ƴ��б�
    				j--;
    			}
    		}
    		item.get(i).setAmount(newAmount);
    		
    	}
    	return item;
    }
    
    //ȥ��List
    public List<Good> onlyGoodList(List<Good> good){
    	List<Good> only = new ArrayList<Good>();
    	for(Good i : good){  
    		   if(!only.contains(i)){  
    		       only.add(i);  
    		        }  
    		    }  

       return only;
    }
    
	
	
	
  }
