package com.haisan.saleOA.dao;

import com.haisan.saleOA.domain.*;

	public interface UserDAO {

		/**
		 * 根据用户名获取 User 对象
		 * @param name
		 * @return
		 */
		public abstract User getUser(String username);
			
	}

