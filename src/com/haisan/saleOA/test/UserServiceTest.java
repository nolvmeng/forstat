package com.haisan.saleOA.test;

import com.haisan.saleOA.domain.User;
import com.haisan.saleOA.service.UserService;

public class UserServiceTest {

	
	UserService userService = new UserService();
	
	
	//UserService��User����ͨ��
	
	
	public static void main(String[] args) {

		UserService userService = new UserService();
		User user = userService.getUser("�麣ɽ");
		System.out.println(user.getUsername());
		
		Boolean is = userService.isLogin("�麣ɽ", "1234");
		System.out.println(is);
		
		
		
	}

}
