package com.haisan.saleOA.web;

import java.util.List;

public class Page<T> {
     
	private int pageNO  ;//��ǰҳ
 
	private int pageSize;//��ҳ��
	
	private int listSzie;//һҳ��ʾ��������¼
	
	private int totalItemNumber = 10;//�ܼ�¼����
	
	private List<T> list;//��ǰҳ��list
	
	
	//���췽����ʼ��pageNO
	public Page(int pageNO){
		super();
		this.pageNO = pageNO;
	}
	
	//��ȡpageNOǰ�����������
	public int getPageNO() {
		if(pageNO < 1){
			pageNO = 1;
		}
		if(pageNO > getTotalPageNumber()){
			pageNO = getTotalPageNumber();
		}
		return pageNO;
	}

	//��ȡ��ҳ������
	public int getTotalPageNumber() {
		/*return (int)(totalItemNumber/listSzie)+1;*/
        int totalPageNumber = (int)totalItemNumber / pageSize;
		
		if(totalItemNumber % pageSize != 0){
			totalPageNumber++;
		}
		
		return totalPageNumber;
	}

	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getListSzie() {
		return listSzie;
	}

	public void setListSzie(int listSzie) {
		this.listSzie = listSzie;
	}

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
	
	//�Ƿ�����һҳ
	public boolean isHasNext(){
		if(getPageNO() < getTotalPageNumber()){
			return true;
		}
		
		return false;
	}
	
	//�Ƿ���ǰһҳ
	public boolean isHasPrev(){
		if(getPageNO() > 1){
			return true;
		}
		
		return false;
	}
	
	//��һҳ
	public int getPrevPage(){
		if(isHasPrev()){
			return getPageNO() - 1;
		}
		
		return getPageNO();
	}
	
	//��һҳ
	public int getNextPage(){
		if(isHasNext()){
			return getPageNO() + 1;
		}
		
		return getPageNO();
	}

	
}
