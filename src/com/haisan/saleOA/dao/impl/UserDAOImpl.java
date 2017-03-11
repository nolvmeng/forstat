package com.haisan.saleOA.dao.impl;
import com.haisan.saleOA.dao.*;
import com.haisan.saleOA.domain.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

	@Override
	public User getUser(String id) {
		String sql = "SELECT userId, username, password, position FROM users WHERE userId = ?";
		
		return query(sql, id);
		
	}
	

}
