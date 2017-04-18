package com.haisan.saleOA.dao.impl;

import java.sql.Date;
import java.util.List;

import com.haisan.saleOA.dao.GoodDAO;
import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.domain.Order;
import com.haisan.saleOA.domain.User;
import com.haisan.saleOA.web.Page;

public class GoodDAOimpl extends BaseDAO<Good> implements GoodDAO  {
    
	@Override
	public Good getGood(String goodId) {
		String sql = "SELECT  goodId,  goodName,  goodPrice,  productDate , reserve,  category"
				   + " FROM goods WHERE goodId = ?";
		return query(sql, goodId);
	}

	@Override
	public int setGood( Good good) {
		String sql = "UPDATE goods SET goodId=?, goodName=?, goodPrice=?, productDate=?, reserve=?"
				+ ", category=? WHERE goodId = ?";
		
		update(sql, good.getGoodId(), good.getGoodName(), good.getGoodPrice(), good.getProductDate()
				, good.getReserve(),good.getCategory(),good.getGoodId());
		System.out.println(sql);
		return 0;
	}

	@Override
	public int addGood(Good good) {
		String sql = "INSERT INTO goods (goodId, goodName, goodPrice, productDate, reserve, category) VALUES(?,?,?,?,?,?)";
		update(sql, good.getGoodId(), good.getGoodName(), good.getGoodPrice(), good.getProductDate()
				, good.getReserve(),good.getCategory());
		return 0;
	}

	@Override
	public List<Good> getSameCa(String categery) {
		String sql = "SELECT  goodId,  goodName,  goodPrice,  productDate , reserve,  category"
				   + " FROM goods WHERE category = ?";
		List<Good> goodList = queryForList(sql, categery);
		return goodList;
	}

	@Override
	public List<Good> getAllGoods() {
		String sql = "SELECT * FROM goods ORDER BY goodId DESC  ";
		List<Good> GList = queryForList(sql);
		return GList;
	}

	@Override
	public List<Good> getPageGood(int start, int pageSize) {
		String sql = "SELECT * FROM goods ORDER BY goodId ASC LIMIT ? ,?"; 
		return queryForList(sql, start, pageSize);
		 
	}

	@Override
	public int getTotalGoodNumber() {
		String sql = "SELECT count(goodId) FROM goods ";
		long num = getSingleVal(sql);
		int n = (int)num;
		return n;
	}

	@Override
	public int getCaTotal(String category) {
		String sql = "SELECT count(goodId) FROM goods WHERE category=?";
		long num = getSingleVal(sql, category);
		int n = (int)num;
		return n;
		
	}

	@Override
	public List<Good> getCaPageGood(int start, int pageSize, String category) {
		String sql = "SELECT * FROM goods WHERE category=? ORDER BY goodId ASC LIMIT ? ,?"; 
		return queryForList(sql, category, start, pageSize);
		
	}

	@Override
	public void updateId(String oldId, String newId) {
		String sql = "UPDATE goods SET goodId=?  WHERE goodId = ?"; 
		update(sql, newId,oldId);
		
	}

	@Override
	public void delGood(String goodId) {
		String sql="DELETE FROM goods WHERE goodId=? ";
		update(sql, goodId);
		
	}

	@Override
	public List<Good> getsomeGood(int start, int pageSize, String goodkey) {
		String sql="SELECT * FROM goods WHERE concat(goodId,goodName,goodPrice,reserve,category) LIKE ?"
				+ " ORDER BY goodId ASC LIMIT ?,?";
		String sql2="%"+goodkey+"%";
		return queryForList(sql, sql2,start,pageSize);
	}

	@Override
	public int getsearchTotal(String goodkey) {
		String sql = "SELECT count(goodId) FROM goods WHERE concat(goodId,goodName,goodPrice,reserve,category) LIKE ? ";
		String sql2="%"+goodkey+"%";
		long num = getSingleVal(sql, sql2);
		int n = (int)num;
		return n;
	}

	@Override
	public List<Good> getsomesearchGood(int start, int pageSize, String category,
			String goodkey) {
		String sql="SELECT * FROM goods WHERE category=? AND concat(goodId,goodName,goodPrice,reserve,category) LIKE ?"
				+ " ORDER BY goodId ASC LIMIT ?,?";
		String sql2="%"+goodkey+"%";
		return queryForList(sql,category,sql2,start,pageSize);
	}

	@Override
	public int getsearchcaTotal(String category,String goodkey) {
		String sql="SELECT count(goodId) FROM goods WHERE category=? AND concat(goodId,goodName,goodPrice,reserve,category) LIKE ?";
		String sql2="%"+goodkey+"%";
		long num = getSingleVal(sql,category, sql2);
		int n = (int)num;
		return n;
	}



}
