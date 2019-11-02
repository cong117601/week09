package com.yunhe.day03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

//使用jdom 解析xml文件 
public class JdomForXml {

	public static void main(String[] args) {
		// 创建sax解析器对象
		SAXBuilder builder = new SAXBuilder();
		try {
			// 使用sax解析器对象解析指定xml文件输入流 ，返回包含指定文档所有元素的对象
			Document alldoc = builder.build(new FileInputStream(new File("src/JDBC.xml")));
			// 获取文档元素对象根节点
			Element rootElement = alldoc.getRootElement();
			// 使用根文档元素对象 获取该文档元素对象 下所有 文档元素 返回 包含所有 子文档元素对象的集合
			List<Element> children = rootElement.getChildren();
			for (Element element : children) {
				List<Element> children2 = element.getChildren();
				for (Element element2 : children2) {
					String name = element2.getName();
					String value = element2.getValue();
					System.out.println(name + ":" + value);
				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (JDOMException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
