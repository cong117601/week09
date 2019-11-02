package com.yunhe.day02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//使用dom解析xml文件
// 注意xml中的节点 嵌套  ，有几层 就得有几层循环  
public class DomForXml {
	public static void parse() {
		// 创建工厂对象
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// 获取新的文档
			DocumentBuilder newDoc = dbf.newDocumentBuilder();
			// 把这个新的文档解析
			Document docparse = newDoc.parse("src/students.xml");
			// 获取文档中的根节点
			Element docroot = docparse.getDocumentElement();
			// 得到文档中的子节点
			NodeList childNodes = docroot.getChildNodes();
			System.out.println(childNodes.getLength());
			// 遍历文档中的 字节点
			for (int i = 1; i < childNodes.getLength(); i += 2) {
				Node item = childNodes.item(i);
				NodeList childNodes2 = item.getChildNodes();
				System.out.println(childNodes2.getLength());
				for (int j = 1; j < childNodes2.getLength(); j += 2) {
					Node item2 = childNodes2.item(j);
					NodeList childNodes3 = item2.getChildNodes();
					System.out.println(childNodes3.getLength());
					for (int k = 1; k < childNodes3.getLength(); k += 2) {
						Node item3 = childNodes3.item(k);
						String nodeName = item3.getNodeName();
						String nodeValue = item3.getFirstChild().getNodeValue();
						System.out.println(nodeName + nodeValue);
					}
				}

			}

		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		} catch (SAXException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		parse();
	}
}
