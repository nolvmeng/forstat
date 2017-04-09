package com.haisan.saleOA.test;

import com.haisan.saleOA.domain.User;
import com.haisan.saleOA.service.UserService;

public class UserServiceTest {

	
	UserService userService = new UserService();
	
	
	//UserService与User测试通过
	
	
	public static void main(String[] args) {

		UserService userService = new UserService();
		User user = userService.getUser("洪海山");
		System.out.println(user.getUsername());
		
		Boolean is = userService.isLogin("洪海山", "1234");
		System.out.println(is);
		
		
		
	}

}
