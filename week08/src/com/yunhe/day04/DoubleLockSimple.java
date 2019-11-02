package com.yunhe.day04;

//双重锁校验(单例)
public class DoubleLockSimple {
	// 使用双重锁进行校验 防止线程中多次调用new
	// 使用同步代码块 使用 volatile关键字修饰变量
	// 进入同步代码块之前进行判断 进入同步后再次进行判断
	public volatile static DoubleLockSimple doubleLockSimple;

	private DoubleLockSimple() {

	}
	public static DoubleLockSimple getInstance() {
		if (doubleLockSimple == null) {
			synchronized (doubleLockSimple.getClass()) {
				if (doubleLockSimple == null) {
					doubleLockSimple = new DoubleLockSimple();
				}
			}
		}
		return doubleLockSimple;

	}
}
