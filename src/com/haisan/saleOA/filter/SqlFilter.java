package com.haisan.saleOA.filter;

import java.io.IOException;  
import java.util.Enumeration;  
import java.util.Iterator;  
  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
//import org.apache.log4j.Logger;  
  
/** 
 * ��sqlע�������,ʹ��ʱ��Ҫע����ܻ���˵��������� 
 * @version 1.0 
 */  
public class SqlFilter implements Filter {  
   // public static final Logger logger = Logger.getLogger(sun.reflect.Reflection.getCallerClass(1));  
      
    //��Ҫ���˵�post����ֵ�ַ�(����Ҫ�ո� ���ܻ��ϵͳ������Ӱ�죬��ע��ɾ���ؼ���)  
    private static String postStr="%20,script,<,>,";  
    //��Ҫ���˵�post�ַ�(���ܻ��ϵͳ������Ӱ�죬��ע��ɾ���ؼ���)  
    //private static String sqlStr="<,>,and,exec,insert,select,%20,delete,update,count,*,%,chr,mid,master,truncate,char,like,declare,&,#,(,),/**/,=,script,\u0023,redirect:,xwork2";  
    // --and , count  
    private static String sqlStr="exec,insert,select,%20,delete,update,chr,master,truncate,char,like,declare,#,/**/,script,\u0023,redirect:,xwork2";  
    //��Ҫ���˵�url�ַ�(���ܻ��ϵͳ������Ӱ�죬��ע��ɾ���ؼ���)  
    private static String urlStr="%20,%22,%27,<,>,master,truncate,char,script,java.lang.ProcessBuilder,java.lang.String,/etc/,\u0023,redirect:,xwork2,\u0073\u0063\u0072\u0069\u0070\u0074";  
    public void destroy() {  
   }  
  
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {  
        request.setCharacterEncoding("utf-8");  
        HttpServletRequest req = (HttpServletRequest)request;  
        HttpServletResponse res = (HttpServletResponse)response;      
  
        Enumeration names = req.getParameterNames();//��ȡ���еı�����  
        String gotoUrl=req.getRequestURI();  //��ȡ���ʵ�url  
        String queryString = req.getQueryString();  
         
        //�ж����еĲ������Ƿ��зǷ��ַ�  
        while(names.hasMoreElements()){           
        String st=names.nextElement().toString();  
               if(strInj(st,sqlStr)||strInj2(st,urlStr)){  
            	   request.setAttribute("msgStr", "�벻Ҫ����Ƿ�����"+" !");  //+req.getParameter(st)
                // res.sendRedirect(req.getContextPath()+"/error.jsp");  
                   request.getRequestDispatcher("/error.jsp").forward(request, response);
       			
                   return;  
               }  
     
        }   
          
        //�ж����еĲ���ֵ�Ƿ��зǷ��ַ�  
        Iterator values = req.getParameterMap().values().iterator();//��ȡ���еı�����  
        while(values.hasNext()){  
           String[] value = (String[])values.next();  
           for(int i = 0;i < value.length;i++){  
               if(strInj(value[i],sqlStr)||strInj2(value[i],postStr)){  
            	   System.out.println("�����ַ����ˣ��벻Ҫ����Ƿ�����");
                   request.setAttribute("msgStr", "�벻Ҫ����Ƿ�����"+" !");  //��ת����ټ��� +value[i]
                  // res.sendRedirect(req.getContextPath()+"/error.jsp");  
                   request.getRequestDispatcher("/error.jsp").forward(request, response);
       			
                   return;  
               }  
  
           }  
        }   
          
        //�жϷ��ʵ�url���Ƿ��зǷ�����  
        if(queryString!=null&&strInj2(queryString,urlStr)){  
                request.setAttribute("msgStr", "�벻Ҫ����Ƿ����� !");  
             // res.sendRedirect(req.getContextPath()+"/error.jsp");  
                request.getRequestDispatcher("/error.jsp").forward(request, response);
    			
                return;  
        }  
      
          
        chain.doFilter(request, response);  
    }  
      
    /** 
     * �ж��ַ��Ƿ�����Ƿ��ַ� 
     * @param str 
     * @return 
     */  
    public static boolean strInj(String str,String standStr){  
        if(str==null||str.length()==0)return false;  
        String[] inj_stra=standStr.split(",");  
        for (int i=0 ; i < inj_stra.length ; i++ ){  
            if (inj_stra[i].length()>0&&str.toLowerCase().indexOf(inj_stra[i])>=0){     
                System.out.println(inj_stra[i]);  
               return true;   
            }  
        }     
        return false;  
    }  
      
    /** 
     * �ж��ַ��Ƿ�����Ƿ��ַ�,û�пո� 
     * @param str 
     * @return 
     */  
    public boolean strInj2(String str,String standStr){  
        if(str==null||str.length()==0)return false;  
        String[] inj_stra=standStr.split(",");  
        for (int i=0 ; i < inj_stra.length ; i++ ){  
            if (inj_stra[i].length()>0&&str.toLowerCase().indexOf(inj_stra[i])>=0){     
               return true;   
            }  
        }     
        return false;  
    }  
  
  
    public void init(FilterConfig cfg) throws ServletException {  
          
    }
 
      
    
} 
