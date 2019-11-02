package com.yunhe.day03;

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

import com.yunhe.day02.student;

public class Dom4jUtil {

	// dom4j 工具类
	public static <E> ArrayList<E> parse(String url, Class<E> c) {
		// 创建DOM4j解析器
		SAXReader sr = new SAXReader();
		ArrayList<E> array = new ArrayList<>();
		try {
			// 创建加载流对象
			Document doc = sr.read(new FileInputStream(new File(url)));
			// 得到根节点
			Element rootElement = doc.getRootElement();
			// 创建迭代器对象
			Iterator<Element> ei = rootElement.elementIterator();
			while (ei.hasNext()) {
				Element childern = ei.next();
				Iterator<Element> ei2 = childern.elementIterator();
				E oe = c.newInstance();
				while (ei2.hasNext()) {
				   Element next = ei2.next();
					String name =next.getName();
					String value =next.getStringValue();
					//System.out.println(value);
					Field field = c.getDeclaredField(name);
					field.setAccessible(true);
					field.set(oe, value);
				}
				array.add(oe);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (DocumentException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		}
		return array;
	}
	public static void main(String[] args) {
		System.out.println(parse("src/students.xml",student.class));
	}
}
