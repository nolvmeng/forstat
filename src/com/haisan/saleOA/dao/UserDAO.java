package com.haisan.saleOA.dao;

import com.haisan.saleOA.domain.*;

	public interface UserDAO {

		/**
		 * �����û�����ȡ User ����
		 * @param name
		 * @return
		 */
		public abstract User getUser(String username);
		
		/**
		 *����ע����Ϣע�����û�
		 * @param id���û�����Id
		 * @param name: �û���
		 * @param password:����
		 * @return
         */
		public abstract void addAUser(String id, String name, String password);
			
	}

