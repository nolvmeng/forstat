package com.haisan.saleOA.web;

import java.util.List;

public class Page<T> {
     
	private int pageNO  ;//当前页
 
	private int pageSize = 10;//一页显示多少条记录
	
	//private int listSzie;//无用
	
	private int totalItemNumber = 10;//总记录条数
	
	private List<T> list;//当前页的list
	
	
	//构造方法初始化pageNO
	public Page(int pageNO){
		super();
		this.pageNO = pageNO;
	}
	
	//获取pageNO前检验其合理性
	public int getPageNO() {
		if(pageNO < 1){
			pageNO = 1;
		}
		if(pageNO > getTotalPageNumber()){
			pageNO = getTotalPageNumber();
		}
		return pageNO;
	}

	//获取总页数方法
	public int getTotalPageNumber() {
		/*return (int)(totalItemNumber/listSzie)+1;*/
        int totalPageNumber = (int)totalItemNumber / getPageSize();
		
		if(totalItemNumber % getPageSize() != 0){
			totalPageNumber++;
		}
		if(totalPageNumber == 0)
			totalPageNumber= 1;  //为空的状态防止分页查表出从-10开始  start=（totalPageNumber-1）* pageSize
		return totalPageNumber;
	}

	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}

	public int getPageSize() {
		if (pageSize <=0 )
			pageSize = 1 ;
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/*public int getListSzie() {
		return listSzie;
	}

	public void setListSzie(int listSzie) {
		this.listSzie = listSzie;
	}*/

	public int getTotalItemNumber() {
		return totalItemNumber;
	}

	public void setTotalItemNumber(int totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	//是否有下一页
	public boolean isHasNext(){
		if(getPageNO() < getTotalPageNumber()){
			return true;
		}
		
		return false;
	}
	
	//是否有前一页
	public boolean isHasPrev(){
		if(getPageNO() > 1){
			return true;
		}
		
		return false;
	}
	
	//上一页
	public int getPrevPage(){
		if(isHasPrev()){
			return getPageNO() - 1;
		}
		
		return getPageNO();
	}
	
	//下一页
	public int getNextPage(){
		if(isHasNext()){
			return getPageNO() + 1;
		}
		
		return getPageNO();
	}

	
}

