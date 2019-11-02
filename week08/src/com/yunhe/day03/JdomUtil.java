package com.yunhe.day03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.yunhe.day02.student;

public class JdomUtil {

	public static void main(String[] args) {
		System.out.println(parse("src/students.xml", student.class));
		//start("src/students.xml");
	}
//打印 孙节点 中 嵌套 的 标签 方法
	public static void print(Element e) {
		List<Element> children = e.getChildren();
		if (children.size() == 0) {
			String name = e.getName();
			String value = e.getValue();
			System.out.println(name + ":" + value);
		}else{
			for (Element element : children) {
				print(element);
			}
		}
		
	}
   public static void start (String url){
	   SAXBuilder sb = new SAXBuilder();
			Document doc;
			try {
				doc = sb.build(new FileInputStream(new File(url)));
				Element rootElement = doc.getRootElement();
				print(rootElement);
			} catch (JDOMException | IOException e) {
				
				e.printStackTrace();
			}
		
   }
	public static <E> ArrayList<E> parse(String url, Class<E> c) {
		// 创建dom4j 解析器
		SAXBuilder sb = new SAXBuilder();
		ArrayList<E> array = new ArrayList<E>();
		try {
			Document doc = sb.build(new FileInputStream(new File(url)));
			Element rootElement = doc.getRootElement();
			List<Element> children = rootElement.getChildren();
			for (Element element : children) {
				List<Element> children2 = element.getChildren();
				E oe = c.newInstance();
				for (Element element2 : children2) {
					String name = element2.getName();
					String value = element2.getValue();
					Field field = c.getDeclaredField(name);
					field.setAccessible(true);
					field.set(oe, value);

				}
				array.add(oe);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (JDOMException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InstantiationException e) {
	
			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {
	
			e.printStackTrace();
		} catch (SecurityException e) {
						e.printStackTrace();
		}

		return array;

	}
}
