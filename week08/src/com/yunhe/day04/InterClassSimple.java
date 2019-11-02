package com.yunhe.day04;

//静态内部类（单例）
public class InterClassSimple {
	// 创建静态内部类
	// 在静态内部类中声明指定类的对象 并创建（final）
	// 在外部类中调用内部类 静态属性返回创建指定单例对象
	public static class InterClass{
		private static final InterClassSimple inter =new InterClassSimple();
		private InterClass(){
			
		}
		public static InterClassSimple getInstance(){
			return InterClass.inter;
			
		}
		
	}
}
