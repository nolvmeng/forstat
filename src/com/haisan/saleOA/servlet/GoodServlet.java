package com.haisan.saleOA.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.domain.User;
import com.haisan.saleOA.service.GoodService;
import com.haisan.saleOA.web.Page;

public class GoodServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	GoodService goodService = new GoodService();
 
	public void destroy() {
		super.destroy();  
		
	}

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           doPost(request, response);
		 
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");  
		response.setCharacterEncoding("UTF-8");  
		request.setCharacterEncoding("UTF-8");  
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

	//��ȡ��Ʒ
	public void AllGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("�ɹ�");

		/*List<Good> goods = goodService.getGoods();
		request.setAttribute("goods", goods);*/
		int pageNO = 1;  int pageSize = 10;
		String some="";
		String cate = "all";
		String NO = request.getParameter("pageNO") ;
		String category = request.getParameter("category");
		request.setAttribute("att_cate",category);
		Page<Good> pageGood = new Page<Good>(1);
		
		if(NO != null) {
			pageNO = Integer.parseInt(NO); 
			System.out.println("xiyuan");
			}
		if(category != null) {
			cate = category;//��ȡ�����������ֵ
		   } 
		if(request.getParameter("search")!=null){
			some = request.getParameter("search");
			System.out.println(some+"�����˴�������");
		}
		if(request.getParameter("searcht")!=null ){
		    some = new String(request.getParameter("searcht").getBytes("iso-8859-1"),"utf-8");
		    System.out.println(some+"�����˴���fanye");
		}
		System.out.println(pageNO+"p");
		 pageGood = goodService.getPageGood(pageNO, pageSize, cate, some);
		  request.setAttribute("pageGood", pageGood);
		  request.setAttribute("mo","AllGoods");
		  request.setAttribute("some", some);
		  
		  if(request.getParameter("new")==null)
		     request.getRequestDispatcher("/WEB-INF/pages/showGood.jsp").forward(request, response);
		  else if(request.getParameter("refresh")==null){
			  request.getRequestDispatcher("OrderServlet?method=chuan&new=is").forward(request, response);
				
		  }  else{
			  request.setAttribute("goods", null);  
			  //request.getSession().setAttribute("good", null);
				System.out.println("�����˴������");
			  request.getRequestDispatcher("/WEB-INF/pages/newAOrder.jsp").forward(request, response); 
		  }
	}
	
	 
	//��ת��ӻ�Ʒ
	public void findjsp(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		request.getRequestDispatcher("/WEB-INF/pages/addAGood.jsp").forward(request, response);
	}
	
	
	//��ת�޸Ļ�Ʒ
			public void changejsp(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
				HttpSession session = request.getSession();
				String id = request.getParameter("id");
				request.setAttribute("id", id);
				if(session.getAttribute(id) != null)
					System.out.println(id);
				//System.out.println("ss");
				request.getRequestDispatcher("/WEB-INF/pages/changeAGood.jsp").forward(request, response);
			}
			
	//�ύ�޸Ļ�Ʒ
		public void setGood(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			HttpSession session = request.getSession();
			String id=(String) session.getAttribute("id");
			String goodId = request.getParameter("goodId");
			String goodName = request.getParameter("goodName");
			String goodPrice = request.getParameter("goodPrice");
			String goodNum = request.getParameter("goodNum");
			String slCategory = request.getParameter("slCategory");
			System.out.println(id);
			int n=Integer.parseInt(goodNum);
			float p=Float.parseFloat(goodPrice);
			goodService.updateId(id, goodId);
			
				Good setGood=new Good();
				setGood.setGoodId(goodId);
				setGood.setGoodName(goodName);
				setGood.setGoodPrice(p);
				setGood.setReserve(n);
				setGood.setCategory(slCategory); 
				goodService.setGood(setGood);
				System.out.println(goodId);
				AllGoods(request,response);
		}
	
	
	
	
	
	//��ӻ�Ʒ
	public void addGood(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String goodId = request.getParameter("goodId");
		String goodName = request.getParameter("goodName");
		String goodPrice = request.getParameter("goodPrice");
		String goodNum = request.getParameter("goodNum");
		String slCategory = request.getParameter("slCategory");
		int n=Integer.parseInt(goodNum);
		float p=Float.parseFloat(goodPrice);
		Good good = goodService.getGood(goodId);//
		if(good == null){
			Good addgood=new Good();
			addgood.setGoodId(goodId);
			addgood.setGoodName(goodName);
			addgood.setGoodPrice(p);
			addgood.setReserve(n);
			addgood.setCategory(slCategory); 
			goodService.addGood(addgood);
			AllGoods(request,response);
		}else{
			
			PrintWriter out = response.getWriter();
			out.flush();//��ջ���
			out.println("<script>");//���script��ǩ
			out.println("alert('��Ʒ�Ѵ��ڣ����������룡');");//js��䣺���alert���
			out.println("history.back();");//js��䣺�����ҳ�������
			out.println("</script>");
		}
	}
	
	//ɾ����Ʒ
		public void delGood(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			HttpSession session = request.getSession();
			String id = request.getParameter("id");
			request.setAttribute("id", id);
			if(session.getAttribute(id) != null)
				System.out.println(id);
			if(id!=null)
				goodService.delGood(id);
			AllGoods(request,response);
		}
	
	
	//����
		public void back(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
			AllGoods(request,response);
		}
	 
	public void init() throws ServletException {
		// Put your code here
	}

}
