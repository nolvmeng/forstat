package com.haisan.saleOA.test;

import java.util.ArrayList;
import java.util.List;

import com.haisan.saleOA.dao.GoodDAO;
import com.haisan.saleOA.dao.ShipmentDAO;
import com.haisan.saleOA.dao.impl.GoodDAOimpl;
import com.haisan.saleOA.dao.impl.ShipmentDAOimpl;
import com.haisan.saleOA.domain.GoodItem;
import com.haisan.saleOA.domain.Shipment;

public class TestShipmentDAO {
     
	ShipmentDAO SS = new ShipmentDAOimpl();
	GoodDAO goodDAO = new GoodDAOimpl();
           
    public void test1(){
        Shipment shipment = SS.getShipment("129", "123");
        if(shipment!=null)  System.out.println(shipment.getAmount());
    }//测试通过
    
    public void test2(){
    	Shipment shipment = new Shipment() ;
    	shipment.setOrderId("61");
		shipment.setGoodId("23");
		shipment.setAmount(113);
		SS.addShipment(shipment);
		  	 
    }//测试通过
    
    public void test3(){
    	List<GoodItem> item = new ArrayList<GoodItem>(4) ;
    	item.add(new GoodItem(goodDAO.getGood("G0001"), 60));
    	item.add(new GoodItem(goodDAO.getGood("G0002"), 1234));
    	item.add(new GoodItem(goodDAO.getGood("G0002"), 34));
    	item.add(new GoodItem(goodDAO.getGood("G0002"), 45));
    	  	
    	//SS.saveBatch(item, "O12345");
    	//测试去重
    	
    	List<GoodItem> only = onlyList(item);
    	for(GoodItem i:only){
    		System.out.println(i.getGood().getGoodId()+i.getAmount());
    	}
    	
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
    }//测试通过
    
    
    
	public static void main(String[] args) {
        TestShipmentDAO tt = new TestShipmentDAO();
        tt.test3();
	}

}
