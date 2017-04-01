package com.haisan.saleOA.service;

import com.haisan.saleOA.dao.UserDAO;
import com.haisan.saleOA.dao.impl.UserDAOImpl;
import com.haisan.saleOA.domain.User;

public class UserService {
	private UserDAO userDAO = new UserDAOImpl();
	
	//����id��ȡuser
	public User getUser(String id){
		return userDAO.getUser(id);
		
	}
	
	//��֤user����
	public Boolean isLogin(String id, String password) {
		User user = getUser(id);
		if(user == null){
			return null;
		}
		
		return user.getPassword().equals(password);
	}
	
	//����˻�
	public User addUser(String id, String name, String password){
		userDAO.addAUser(id, name, password);		
        return userDAO.getUser(id);		//�����½����û������ڷ����Ƿ񴴽�
	}
	
}
