package com.haisan.saleOA.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haisan.saleOA.domain.User;
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
		//��֤��¼
		String id = request.getParameter("id");
		String password =  request.getParameter("password");
		HttpSession session = request.getSession();//session
		Boolean isTrue = userService.isLogin(id, password);
		if(isTrue == true){ 
		    System.out.println(id+password+isTrue + "OCK!");
		    
	        User userw = userService.getUser(id);
	        session.setAttribute("userw", userw);//session��¼��¼�û�
	        session.setAttribute("suss", true);
			System.out.print(userw.getUsername());
			
		 
			request.getRequestDispatcher("/servlet/GoodServlet?method=AllGoods").forward(request, response);
			
			//request.getRequestDispatcher("/WEB-INF/pages/showGood.jsp").forward(request, response);
		}else {
			/*response.setContentType("charset=gb312");
			PrintWriter out = response.getWriter();
			out.flush();//��ջ���
			out.println("<script>");//���script��ǩ
			out.println("alert('�û�����һ�»�����������������룡');");//js��䣺���alert���
			out.println("history.back();");//js��䣺�����ҳ�������
			out.println("</script>");*/
			boolean suss=false;
			session.setAttribute("suss", suss);
			 response.sendRedirect("/saleOA/index.jsp");
		}
	}
	
	public void addUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//�����û�
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = userService.addUser(userId, userName, password);
		if(user != null) {
			System.out.println( "upCK!");
		    HttpSession session = request.getSession();//session
	        User userw = userService.getUser(userId);
	        session.setAttribute("userw", userw);//session��¼��¼�û�
	        request.getRequestDispatcher("//testLogin.jsp").forward(request, response);
	         }/*else {
		           	System.out.println();
	                response.sendRedirect("//error.jsp");
            }*/
		}
	
	
	public void destoryUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//�����û�
		
	        HttpSession session = request.getSession();
	        if(session != null)
               session.invalidate();
	        response.sendRedirect("/saleOA/index.jsp");
			
           
	}

}
