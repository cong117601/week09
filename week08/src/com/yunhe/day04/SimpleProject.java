package com.yunhe.day04;
//最基础的单例模式
public class SimpleProject {
private static SimpleProject simple;
private SimpleProject(){
	
};
public static SimpleProject getInstance(){
	if(simple==null){
		simple = new SimpleProject();
	}
	return simple;
	
}
public static void main(String[] args) {
	SimpleProject instance = SimpleProject.getInstance();
	
}

}
