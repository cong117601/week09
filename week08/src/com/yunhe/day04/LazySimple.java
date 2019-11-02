package com.yunhe.day04;
//懒人模式（单例）线程安全
public class LazySimple {
//在创建对象时不会进行对象的声明创建使用null
//只有在方法调用时才会创建对象 
	private static LazySimple lazySimple;
	private LazySimple(){
		
	};
	public static synchronized LazySimple getInstance(){
		if(lazySimple==null){
			lazySimple=new LazySimple();
		}
		return lazySimple;	
	}
	public static void main(String[] args) {
		LazySimple instance = LazySimple.getInstance();
	}
}
