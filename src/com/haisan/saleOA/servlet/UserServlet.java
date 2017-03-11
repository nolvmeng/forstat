package com.haisan.saleOA.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haisan.saleOA.service.UserService;

public class UserServlet extends HttpServlet {
    
	private UserService userService = new UserService(); 
 
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

 
	public void init() throws ServletException {
	
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//ÑéÖ¤µÇÂ¼
		String id = request.getParameter("id");
		String password =  request.getParameter("password");
		
		Boolean isTrue = userService.isLogin(id, password);
		
		
		System.out.println(id+password+isTrue + "OCK!");
		request.getRequestDispatcher("//success.jsp").forward(request, response);	    
		
	}
	
	

}
