package com.yunhe.day02;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Administrator
 * @title DOMUtil
 * @Description DOM解析 xml 工具类
 * @param 解析文件地址
 *            URL string url; 反射 Class<E> c;
 * @return array集合
 */
public class DOMUtil {
	public static <E> ArrayList<E> parse(String url, Class<E> c) {
		ArrayList<E> array = new ArrayList<>();
		// 创建文档 创建工厂对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 获取新的文档 创建对象
		try {
			DocumentBuilder newdocument = dbf.newDocumentBuilder();
			// 将给定URI的内容解析为一个xml文档，并返回Document对象
			Document doc = newdocument.parse(url);
			// 按文档顺序 返回包含在文档中 且具有指定标记名称的所有Element 的 NodeList
			Element e = doc.getDocumentElement();// 获取根节点
			// System.out.println(e);
			// 得到文档中的所有子节点
			NodeList allchildNodes = e.getChildNodes();
			// System.out.println(allchildNodes);

			for (int i = 0; i < allchildNodes.getLength(); i++) {
				Node item = allchildNodes.item(i);// 返回 第 i个 子节点
				//System.out.println(item);
				if(item.getNodeName().equals("#text")){
					continue;//跳出本次循环  进入下次 循环
				}
				NodeList lists = item.getChildNodes();
				E newobj = c.newInstance();// 使用泛型  创建对应对象
				for (int j = 0; j < lists.getLength(); j ++) {
					Node sitem = lists.item(j); // 返回第 j个孙节点
					if(sitem.getNodeName().equals("#text")){
						continue;
					}
					// System.out.println(item2);
					String nodeName = sitem.getNodeName();
					Field field = c.getDeclaredField(nodeName);// 得到属性
					String value = sitem.getFirstChild().getNodeValue();
					// 修改权限
					field.setAccessible(true);
					// 写入值
					field.set(newobj, value);
				}
				array.add(newobj);
			}
		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		} catch (SAXException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InstantiationException e1) {

			e1.printStackTrace();
		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {

			e1.printStackTrace();
		} catch (SecurityException e1) {

			e1.printStackTrace();
		}

		return array;

	}

	public static void main(String[] args) {
		ArrayList<student> parse = parse("src/students.xml", student.class);
		System.out.println(parse);
		for (student student : parse) {
			System.out.println(student);
		}
		//System.out.println(parse.get(0).getId());

	}
}
