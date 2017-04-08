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
		
		if(position.equals("simple")){//区分用户等级权限
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
	
	//获取订单页
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
	
	
	 

	//获取订单列表
	private List<OrderItem> getOrederItem(List<Order> listOrder) {
		// Page<Order> pageOrder = getAllOrder( start,  pageSize,  userId);
		// List<Order> listOrder = pageOrder.getList();//获取订单列表
		 List<OrderItem> listItems  = new ArrayList<OrderItem>();
         for(Order o : listOrder){
        	 listItems.add(getItem(o));
         }
		 
		return listItems;
	}
  
	 
	//根据order返回OrderItem 
	private OrderItem getItem(Order order) {
		OrderItem item = new OrderItem();
		List<GoodItem> goodList = new ArrayList<GoodItem>(); 
		List<Good> goods = GService.getListGood(SDao.getgetListGood(order.getOrderId()));//获取货物表
		
		for(Good d : goods){
     		GoodItem  good = new GoodItem( d, SDao.getShipment(order.getOrderId(), d.getGoodId()).getAmount());
     		goodList.add(good);
		}
        item.setGoodList(goodList);//装进货物表		
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
	 
	
	
	
	
	 public void addOrder(List<GoodItem> items, Order order){
		String orderId = "Test129";//
		Date orderDate = new Date(System.currentTimeMillis());//获取当前日期
		order.setOrderId(orderId);
		order.setOrderDate(orderDate);
		ODao.addOrder(order);
		SService.addBatch(items, order.getOrderId());
	 }
	 
	 public Order getOrder(String orderId){
		 return ODao.getOrder(orderId);
		 
	 }
	 
	

}
