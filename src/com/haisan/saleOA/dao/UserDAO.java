package com.haisan.saleOA.dao;

import com.haisan.saleOA.domain.*;

	public interface UserDAO {

		/**
		 * �����û�����ȡ User ����
		 * @param name
		 * @return
		 */
		public abstract User getUser(String username);
			
	}

