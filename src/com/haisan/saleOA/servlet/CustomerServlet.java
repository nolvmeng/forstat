package com.haisan.saleOA.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haisan.saleOA.domain.Customer;
import com.haisan.saleOA.service.CustomerService;
import com.haisan.saleOA.web.Page;

public class CustomerServlet extends HttpServlet {

	CustomerService customerService = new CustomerService();  
	
	
	
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
		request.setCharacterEncoding("utf-8");
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
		 
	}
   
	public void getCus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Page<Customer> pageCus = new Page<Customer>(1);
		int pageNO = 1;  int pageSize = 10;//默认值
		String NO = request.getParameter("pageNO");
		//int pageSizev = request.getParameter("pageSize");
		System.out.println("进入som");
		if(NO != null)
			pageNO = Integer.parseInt(NO);
 		pageCus = customerService.getPageCus(pageNO, pageSize);
 		request.setAttribute("pageCus", pageCus);
 		request.getRequestDispatcher("/WEB-INF/pages/showCustomers.jsp").forward(request, response);
	}
	
	
	 public void findjsp(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		 request.getRequestDispatcher("/WEB-INF/pages/addCustomer.jsp").forward(request, response);
	 }
	 
	 
	 public void addCustomer(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		 String cusId = request.getParameter("cusId");
			String cusName = request.getParameter("cusName");
			String cusAddress = request.getParameter("cusAddress");
			String cusPhone = request.getParameter("cusPhone");
		   if(cusId!=null){
		    
			Customer cus=new Customer();
			cus.setCustomerId(cusId);
			cus.setCustomerName(cusName);
			cus.setAddress(cusAddress);
			cus.setPhoneNum(cusPhone);
			customerService.addCustomer(cus);
			getCus(request, response);
			}
			}
	public void init() throws ServletException {
		// Put your code here
	}

}
