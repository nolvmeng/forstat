package com.haisan.saleOA.test;

import java.sql.Date;

import com.haisan.saleOA.dao.impl.BaseDAO;


public class baseDAOTest {

	
	BaseDAO tt = new BaseDAO(); 
	
	public void insertText(){
		String sql = "INSERT INTO users (userId, username, password, position) VALUES(? ,? , ?, ?)";
		long id = tt.insert(sql, "hoksljshdka","mosi","sosl","baidu");
	
		System.out.println(id); 
	 
	}//≤‚ ‘Õ®π˝
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		baseDAOTest test = new baseDAOTest();
		test.insertText();
	

}
}