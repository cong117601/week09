package com.yunhe.day02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

//使用dom4j解析xml文件工具类
//要看解析的xml文件的结构 ，根节点下有子节点  子节点中是否有孙节点
public class Dom4jUtil {
	public static <E> ArrayList<E> parse(String url, Class<E> c) {
		ArrayList<E> arr = new ArrayList<E>();
		// 创建解析器对象
		SAXReader xr = new SAXReader();
		// 使用解析器对象读取文档
		try {
			Document doc = xr.read(new FileInputStream(new File(url)));
			// 得到文档中的根节点
			Element rootElement = doc.getRootElement();
			// 创建迭代器
			Iterator<Element> ei1 = rootElement.elementIterator();
			while (ei1.hasNext()) {
				Element child = ei1.next();
				Iterator<Element> ei2 = child.elementIterator();
				
				while(ei2.hasNext()){
					 Element sun = ei2.next();
					 Iterator<Element> ei3 = sun.elementIterator();
					 E oe = c.newInstance();
					 while(ei3.hasNext()){
						 Element next = ei3.next();
						 String name = next.getName();
						 String value = next.getStringValue();
						 Field field = c.getDeclaredField(name);
							field.setAccessible(true);
							field.set(oe, value);
					 }
						arr.add(oe);
				}
			
			}
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {

			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		return arr;

	}
	public static void main(String[] args) {
		ArrayList<student> parse = parse("src/students.xml",student.class);
System.out.println(parse.size());
			
		
	}
}
