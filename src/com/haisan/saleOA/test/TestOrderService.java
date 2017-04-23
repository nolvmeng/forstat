package com.haisan.saleOA.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.haisan.saleOA.domain.Good;
import com.haisan.saleOA.service.GoodService;
import com.haisan.saleOA.service.OrderService;
import com.haisan.saleOA.service.ShipmentService;


public class TestOrderService {
      GoodService Gs = new GoodService();
      ShipmentService Ss = new ShipmentService();
      List<Good> goods = new ArrayList<Good>();
      List<Good> good = new ArrayList<Good>();
     
      
      
      
	public static void main(String[] args) {
       TestOrderService TTTT = new TestOrderService();
		 for(int i=0;i<3;i++){
    	  TTTT.goods.add(TTTT.Gs.getGood("G0001"));
      }
            System.out.println(TTTT.goods );
            TTTT.good = TTTT.Ss.onlyGoodList(TTTT.goods);
            System.out.println(TTTT.good );
            HashSet<Good> hs = new HashSet<Good>(TTTT.goods);
            System.out.println(hs);
	}

}
