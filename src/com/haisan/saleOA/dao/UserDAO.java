package com.haisan.saleOA.dao;

import com.haisan.saleOA.domain.*;

	public interface UserDAO {

		/**
		 * 根据用户名获取 User 对象
		 * @param name
		 * @return
		 */
		public abstract User getUser(String username);
		
		/**
		 *根据注册信息注册新用户
		 * @param id：用户将用Id
		 * @param name: 用户名
		 * @param password:密码
		 * @return
         */
		public abstract void addAUser(String id, String name, String password);
			
	}

