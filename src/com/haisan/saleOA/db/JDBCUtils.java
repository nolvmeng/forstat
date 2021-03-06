package com.haisan.saleOA.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.haisan.saleOA.exception.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * JDBC 的工具类
 *
 */
public class JDBCUtils {

	private static DataSource dataSource = null;
	
	static{
		dataSource = new ComboPooledDataSource("javawebapp");
	}
	
	//获取数据库连接
		public static Connection getConnection(){  
			try { 
				return dataSource.getConnection();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new DBException("数据库连接错误!");
			}
		}
	
		//关闭数据库连接
		public static void release(Connection connection) {
			try {
				if(connection != null){
					connection.close();
					System.out.println("关闭连接");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("数据库关闭错误!");
			}
		}
		
		//关闭数据库连接
		public static void release(ResultSet rs, Statement statement) {
			try {
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("数据库关闭错误!");
			}
			
			try {
				if(statement != null){
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("数据库关闭错误!");
			}
		}
	
	
}
