package com.haisan.saleOA.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.domain.User;
import com.haisan.saleOA.service.GoodService;

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

	//获取货品
	public void AllGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("成功");

		List<Good> goods = goodService.getGoods();
		request.setAttribute("goods", goods);
		  //HttpSession session = request.getSession();//session
	     //   User userw = userService.getUser(id);
	      //  session.setAttribute("userw", userw);//session记录登录用户
		
		request.getRequestDispatcher("/WEB-INF/pages/showGood.jsp").forward(request, response);
		
	}
	
	
	 
	public void init() throws ServletException {
		// Put your code here
	}

}
