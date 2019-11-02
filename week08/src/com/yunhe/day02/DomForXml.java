package com.yunhe.day02;

import java.io.IOException;
import java.util.ArrayList;

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
 * @title  DomForXml
 * @Description 进行读取student.xml 文件
 * @param 
 * @return 
 */
public class DomForXml {
	public static void main(String[] args) {
		//创建文档 创建工厂对象
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		//获取新的文档 创建对象 
		try {
			DocumentBuilder db = dbFactory.newDocumentBuilder();
		//将给定URI的内容解析为一个xml文档，并返回Document对象
			Document document = db.parse("src/JDBC.xml");
		//按文档顺序   返回包含在文档中 且具有指定标记名称的所有Element 的 NodeList	
		
			Element e = document.getDocumentElement();//获取根节点
			//System.out.println(e);
			NodeList allchildNodes = e.getChildNodes();//得到 文档中的所有子节点
			System.out.println(allchildNodes.getLength());
			for (int i = 1; i < allchildNodes.getLength(); i+=2) {
				Node item = allchildNodes.item(i);
				NodeList childNodes = item.getChildNodes();
				//System.out.println(childNodes);
				for (int j = 1; j<childNodes.getLength(); j+=2) {
					Node item2 = childNodes.item(j);
					//item2.getTextContent();
					String nodeName = item2.getNodeName();
					String nodevalue = item2.getFirstChild().getNodeValue();
					System.out.println(nodeName+":"+nodevalue);
					//System.out.println(item2.getTextContent());
				}
				System.out.println();
			}
	
		} catch (ParserConfigurationException e) {
			
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
