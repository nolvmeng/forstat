package com.haisan.saleOA.service;

import com.haisan.saleOA.dao.UserDAO;
import com.haisan.saleOA.dao.impl.UserDAOImpl;
import com.haisan.saleOA.domain.User;

public class UserService {
	private UserDAO userDAO = new UserDAOImpl();
	
	//根据id获取user
	public User getUser(String id){
		return userDAO.getUser(id);
		
	}
	
	//验证user密码
	public Boolean isLogin(String id, String password) {
		User user = getUser(id);
		if(user == null){
			return null;
		}
		
		return user.getPassword().equals(password);
	}
	
	//添加账户
	public User addUser(String id, String name, String password){
		userDAO.addAUser(id, name, password);		
        return userDAO.getUser(id);		//返回新建的用户，用于反馈是否创建
	}
	
}
