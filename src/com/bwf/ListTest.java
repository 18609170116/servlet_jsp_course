package com.bwf;


import java.util.ArrayList;
import java.util.List;

public class ListTest {
	
	List init(){
		ArrayList list = new ArrayList();
		for(int i=0;i<100;i++){
			list.add(i+"");
		}
		for(int i=0;i<100;i++){
			list.add(i+"");
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListTest lt = new ListTest();
		List list = lt.init();
		
		System.out.println(list.size());
		
		for (int i = list.size()-1; i >0; i--) {
			String content = (String)list.get(i);
			list.remove(content);
			System.out.println(list.size());
		}
	}

}
