package com.yunhe.day05;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		
		      ArrayList<Integer> arrayList = new ArrayList<>();
			         for (int i = 0; i < 20; i++) {
			              arrayList.add(Integer.valueOf(i));
			        }
			   System.out.print(arrayList);
			         Iterator<Integer> iterator = arrayList.iterator();
	                  while (iterator.hasNext()) {
	                     Integer integer = iterator.next();
	                    if (integer.intValue() == 5) {
	                    	 arrayList.remove(integer);
	                    }  
	                
	                   
	                  } 
	                  for (Integer integer : arrayList) {
						System.out.println(integer);
					}
}
}