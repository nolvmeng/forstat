package com.haisan.saleOA.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.haisan.saleOA.dao.*;
import com.haisan.saleOA.db.JDBCUtils;
import com.haisan.saleOA.utils.ReflectionUtils;
import com.haisan.saleOA.web.ConnectionContext;


public class BaseDAO<T> implements Dao<T>{
	
	private QueryRunner queryRunner = new QueryRunner();

	private Class<T> clazz;
	
	public BaseDAO() {
		clazz = ReflectionUtils.getSuperGenericType(getClass());
	}

	@Override
	public long insert(String sql, Object... args) {
		// TODO Auto-generated method stub
		long id = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JDBCUtils.getConnection();
			//connection = ConnectionContext.getInstance().get();
			if(connection!=null) System.out.println("fg");
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			if(args != null){
				for(int i = 0; i < args.length; i++){
					preparedStatement.setObject(i + 1, args[i]);
				}
			}
			
			preparedStatement.executeUpdate();
			
			//获取生成的主键值
			resultSet = preparedStatement.getGeneratedKeys();
			if(resultSet.next()){
				id = resultSet.getLong(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtils.release(resultSet, preparedStatement);
		}
		
		return id;
	}

	@Override
	public void update(String sql, Object... args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T query(String sql, Object... args) {
		Connection connection = null;		
		try {
			//connection = JDBCUtils.getConnection();
			connection = ConnectionContext.getInstance().get();
			if(connection!=null) System.out.println("非空连接");
			return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
		
		
	}

	@Override
	public List<T> queryForList(String sql, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> V getSingleVal(String sql, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void batch(String sql, Object[]... params) {
		// TODO Auto-generated method stub
		
	}
    
	
}
