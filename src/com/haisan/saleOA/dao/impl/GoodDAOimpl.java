package com.haisan.saleOA.dao.impl;

import java.sql.Date;
import java.util.List;

import com.haisan.saleOA.dao.GoodDAO;
import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.domain.User;

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
		System.out.println(sql);
		update(sql, good.getGoodId(),good.getGoodId(), good.getGoodName(), good.getGoodPrice(), good.getProductDate()
				, good.getReserve(),good.getCategory(),good.getGoodId());
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

}
