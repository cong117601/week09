package com.yunhe.day03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jForXml {
public static void main(String[] args) {
	//使用dom4j 创建 解析器 
     SAXReader sr= new SAXReader();
     //解析指定sxm 文件
      try {
		Document doc = sr.read(new FileInputStream(new File("src/students.xml")));
		//获取根节点元素对象 
		Element rootElement = doc.getRootElement();
		//创建元素  迭代器
		Iterator<Element> e= rootElement.elementIterator();
		//判断集合中 是否 有值
		while(e.hasNext()){
			
			//Element next = (Element) e.next(); // 不转型  返回的是  object类型   所以加 泛型 可以不用 转换
			Element next = e.next();//得到的是 子节点 集合
			Iterator<Element> e2 = next.elementIterator();
			while(e2.hasNext()){
				//Element next2 =(Element) e2.next();
				Element next2 = e2.next();
//				if(next2.getName().equals("name")){
//					System.out.println(next2.getName()+":"+next2.getStringValue());
//				}
//				if(next2.getName().equals("age")){
//					System.out.println(next2.getName()+":"+next2.getStringValue());
//				}
					String name = next2.getName();
					String Value = next2.getStringValue();
					System.out.println(name+":"+Value);
			
			}
		}
		
		
		
	} catch (FileNotFoundException | DocumentException e) {
		
		e.printStackTrace();
	}
}
}
