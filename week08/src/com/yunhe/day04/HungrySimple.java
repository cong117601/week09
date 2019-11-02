package com.yunhe.day04;
//饿汉模式
public class HungrySimple {
	//在创建对象时进行对象的声明创建
private static HungrySimple hungrySimple =new HungrySimple();
private HungrySimple(){
	
};
public static HungrySimple getInstance(){
	return hungrySimple;
	
}
public static void main(String[] args) {
	HungrySimple instance = HungrySimple.getInstance();
}
}
