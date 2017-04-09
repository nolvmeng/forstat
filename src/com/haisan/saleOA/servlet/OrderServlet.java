package com.haisan.saleOA.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.domain.GoodItem;
import com.haisan.saleOA.domain.Order;
import com.haisan.saleOA.domain.OrderItem;
import com.haisan.saleOA.domain.Shipment;
import com.haisan.saleOA.domain.User;
import com.haisan.saleOA.service.GoodService;
import com.haisan.saleOA.service.OrderService;
import com.haisan.saleOA.service.ShipmentService;
import com.haisan.saleOA.service.UserService;
import com.haisan.saleOA.web.Page;

public class OrderServlet extends HttpServlet {

	OrderService OService = new OrderService();
	UserService UService = new UserService();
	GoodService GService = new GoodService();
	ShipmentService SService = new ShipmentService();
	  List<Good> gooditem= new ArrayList<Good>();
      List<Shipment> ship = new ArrayList<Shipment>();	
      
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doPost(request, response);
		 
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methodName = request.getParameter("method");
		if (methodName !=null) {
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		}
		//System.out.println("OK!");
		
		
	}
	public void getOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Page<OrderItem> pageOrder = new Page<OrderItem>(1);
		int pageNO = 1; int pageSize = 10;
		User user = (User) request.getSession().getAttribute("userw");
		if(user == null)  response.sendRedirect("/saleOA/index.jsp");//未登录状态下，返回登录页
		System.out.println(user.getUsername());
		pageOrder = OService.getPageOrder(pageNO, pageSize, user.getUserId());
		if(pageOrder.getList() != null) System.out.println("已进入Or"+user.getUserId());
	  	request.setAttribute("pageOrder", pageOrder);
	  	
	  	
	  	request.getRequestDispatcher("/WEB-INF/pages/showOrder.jsp").forward(request, response);
	  	
	}
	
	public void newOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/pages/newAOrder.jsp").forward(request, response);
		
		
	}
	
	//进入核对订单
	public  void toCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 gooditem =(List<Good>) request.getAttribute("good");
	           if(request.getSession().getAttribute("good")!= null) {
	        	   System.out.println("xiyan");
	              // request.setAttribute("goods", gooditem);
	               }
	           request.getRequestDispatcher("/WEB-INF/pages/checkAOrder.jsp").forward(request, response);
	           gooditem = new ArrayList<Good>();//初始化以达到清除效果
	           request.setAttribute("goods", gooditem);
	}
	          // gooditem.clear();
	
	//确认数量，完成新订单
	public void toCheckSu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		List<Good> items = (List<Good>) request.getSession().getAttribute("good");
		User user = (User)request.getSession().getAttribute("userw");
		List<Shipment> ship = new ArrayList<Shipment>();
		String userId =" ";
	    if(user != null)  
		    userId = user.getUserId();
		if(items != null){
			 
			 String customerId ="C1234567";//改为参数获取
			 Order order = new Order();
			 order.setCustomerId(customerId);
			 order.setUserId(userId);
			 
			 for(int i=0;i<items.size();i++){
				 Good good = items.get(i);
				 int amount = 0;
				 if(request.getParameter(i+"")!=null){
					 amount = Integer.parseInt(request.getParameter(i+""));
					 Shipment shipment =new Shipment();
				 shipment.setGoodId(good.getGoodId());
				 shipment.setPrive(good.getGoodPrice());
				 shipment.setAmount(amount);//设置货品数量
				 ship.add(shipment);
				// System.out.println(items.get(i).getAmount());
				 }
			 }
			 //System.out.println(items.size());
			 
			OService.addOrder(items, order, ship); 
		}
		
		 
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/pages/checkAOrder.jsp").forward(request, response);
	}
	
	public void addGood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 //gooditem = new ArrayList<Good>();
		String id =request.getParameter("Id");
		
		if(request.getParameter("Id") != null){
		  Good good = GService.getGood(id);
		  System.out.println("xinid为非空"+id);
		  gooditem.add(good);
		}
	/*	HttpSession ss = request.getSession();
				ss.setAttribute("goods", null);*/
		
		
		gooditem = SService.onlyGoodList(gooditem);
		System.out.println(gooditem.size());
		request.setAttribute("goods", gooditem);
		request.getRequestDispatcher("GoodServlet?method=AllGoods&new=is").forward(request, response);
		
	}
	 
	
	//传参显示订单详细
		public void getAOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			
			HttpSession session = request.getSession();
			String id = request.getParameter("id");
			request.setAttribute("id", id);
			
			if(session.getAttribute(id) != null)
				System.out.println(id);
			System.out.println("ss");
			
			request.getRequestDispatcher("/WEB-INF/pages/showAOrder.jsp").forward(request, response);
			
		}
		
	

	public void init() throws ServletException {
		// Put your code here
	}

}
