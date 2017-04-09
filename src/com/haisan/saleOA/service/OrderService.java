package com.haisan.saleOA.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.haisan.saleOA.dao.impl.CustomerDAOimpl;
import com.haisan.saleOA.dao.impl.OrderDAOimpl;
import com.haisan.saleOA.dao.impl.ShipmentDAOimpl;
import com.haisan.saleOA.dao.impl.UserDAOimpl;
import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.domain.GoodItem;
import com.haisan.saleOA.domain.Order;
import com.haisan.saleOA.domain.OrderItem;
import com.haisan.saleOA.domain.Shipment;
import com.haisan.saleOA.domain.User;
import com.haisan.saleOA.web.Page;

public class OrderService {
	
	OrderDAOimpl ODao = new OrderDAOimpl();
	UserDAOimpl UDao = new UserDAOimpl();
	ShipmentDAOimpl SDao = new ShipmentDAOimpl();
	CustomerDAOimpl CDao = new CustomerDAOimpl();
	GoodService GService = new GoodService();
	ShipmentService SService = new ShipmentService();
/*	
	public  Page<Order> getAllOrder(int pageNO, int pageSize, String userId){
		User user = UDao.getUser(userId);
		String position = user.getPosition();
		Page<Order> pageOrder = new Page<Order>(1);
		pageOrder.setPageNO(pageNO);
		pageOrder.setPageSize(pageSize);
	 //   Map<String, Double> total = new HashMap<String, Double>(); 
		
		if(position.equals("simple")){//�����û��ȼ�Ȩ��
			pageOrder.setTotalItemNumber(ODao.getTotalNum(userId));
			int start = (pageOrder.getPageNO()-1)*pageOrder.getPageSize();
			pageOrder.setList(ODao.getOrderList(start, pageOrder.getPageSize(), userId));
			
			
		} else {
			pageOrder.setTotalItemNumber(ODao.getTotalNum());
			int start = (pageOrder.getPageNO()-1)*pageOrder.getPageSize();
			pageOrder.setList(ODao.getOrderList(start, pageOrder.getPageSize()));
			
		}
		 
		return pageOrder;
		
	}*/
	
	//��ȡ����ҳ
	public Page<OrderItem> getPageOrder(int pageNO, int pageSize, String userId){
		User user = UDao.getUser(userId);
		String position = user.getPosition();
		Page<OrderItem> pageOItem = new Page<OrderItem>(1);
		pageOItem.setPageNO(pageNO);
		pageOItem.setPageSize(pageSize);
	
		if(position.equals("simple")){
			pageOItem.setTotalItemNumber(ODao.getTotalNum(userId));
			int start = (pageOItem.getPageNO()-1)*pageOItem.getPageSize();
			 List<Order> listOrder = ODao.getOrderList(start,  pageSize,  userId);
			pageOItem.setList(getOrederItem(listOrder));
			
			
		} else {
			pageOItem.setTotalItemNumber(ODao.getTotalNum());
			int start = (pageOItem.getPageNO()-1)*pageOItem.getPageSize();
			 List<Order> listOrder = ODao.getOrderList(start,  pageSize);
			pageOItem.setList(getOrederItem(listOrder));
			
		}
		 
		return pageOItem;
		
		
	}
	
	
	 

	//��ȡ�����б�
	private List<OrderItem> getOrederItem(List<Order> listOrder) {
		
		 List<OrderItem> listItems  = new ArrayList<OrderItem>();
		 
         for(Order o : listOrder){
        	 listItems.add(getItem(o));
         }
		 
		return listItems;
	}
  
	 
	//����order����OrderItem 
	private OrderItem getItem(Order order) {
		OrderItem item = new OrderItem();
		//List<Good> goodList = new ArrayList<Good>();
		List<Shipment> shipmentList = new ArrayList<Shipment>();
		List<Good> goods = GService.getListGood(SDao.getgetListGood(order.getOrderId()));//��ȡ�����
		
		for(Good d : goods){
     	
			Shipment shipment = SDao.getShipment(order.getOrderId(), d.getGoodId());
		//	System.out.println("getTatalPriceS��׮����"+order.getOrderId()+":->"+ d.getGoodId()+":->"+shipment.getTotalPriceS());
			shipmentList.add(shipment);
			
		}
        item.setGoodList(goods);//װ�������		
        item.setShipmentList(shipmentList);
		item.setOrder(order);
		item.setUserId(order.getUserId());
		item.setCustomer(CDao.getCustomer(order.getCustomerId()));
		
		return item;
	}

 
	
	
	
	/*public Map<String, Double> getTotal(List<Order> list){ 
		 double money = 0.0;
		 if(list != null)
		 System.out.println("weikong");
		 Map<String, Double> total = new HashMap<String, Double>();
		 for(Order o : list){
			 System.out.println("weikong++++");
			 System.out.println(o.getOrderId());
			 money = ODao.getTotal(o.getOrderId());
			  if(money!=0.0)
			  total.put(o.getOrderId(), ODao.getTotal(o.getOrderId()));
		 }
	//	 if(total != null) System.out.println("weikong");
 		 
		 return total;
		 
	 }*/
	 
	
	
	
	
	/* public void addOrder(List<GoodItem> items, Order order){
		String orderId = "Test129";//
		Date orderDate = new Date(System.currentTimeMillis());//��ȡ��ǰ����
		order.setOrderId(orderId);
		order.setOrderDate(orderDate);
		ODao.addOrder(order);
		SService.addBatch(items, order.getOrderId());
	 }*/
	 
	 public Order getOrder(String orderId){
		 return ODao.getOrder(orderId);
		 
	 }




	public void addOrder(List<Good> items, Order order, List<Shipment> ship) {
		              int i=0;
		              String orderId = "Test119";//���ò����
		              Date orderDate = new Date(System.currentTimeMillis());//��ȡ��ǰ����
		      		  order.setOrderId(orderId);
		      		  order.setOrderDate(orderDate);
                      for(Good d:items){
                    	  ship.get(i).setOrderId(orderId);
                    	  i++;
                      }		
                      ODao.addOrder(order);
                      SService.addBatch(ship);
                      
                      
	}
	 
	

}
