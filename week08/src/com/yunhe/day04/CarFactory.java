package com.yunhe.day04;
//汽车工厂
public class CarFactory {
  public static  Car getCar(String carName){
	  Car c =null;
	  if("奔驰".equals(carName)){
		  c=new Benz();
	  }else if("宝马".equals(carName)){
		  c=new Bmw();
	  }
	return c;
	  
  }
  public static void main(String[] args) {
	  Car car = getCar("宝马");
	  car.run();
	
}
}
