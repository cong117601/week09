/**
 * 
 */
package com.yunhe.day02;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Administrator
 * @title
 * @Description
 * @param
 * @return
 */

public class SAXForXml extends DefaultHandler {
	private List<student> students;
    private String currentTag; // 记录当前解析到的节点名称
    private student stduent; // 记录当前的user

	@Override
	// 开始加载文件方法
	// 文档解析开始时调用，该方法只会调用一次
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("文档开始解析");
		students=new ArrayList<student>();
	}

	
	@Override
	// 开始解析标签
	// uri:文档的命名空间
	// localname: 不带前缀的名字
	// qName:带前缀的名字
	// attributes:标签的属性集
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
	} 
	@Override
	
	// 解析标签内容 
	// char[] ch:当前读取到的TextNode(文本节点)的字节数组
	//int start: 字节开始的位置，为0则读取全部
	//int length:当前TextNode的长度
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);

	}

	@Override
	// 结束解析标签    , 标签（节点）解析结束后调用
	public void endElement(String uri, String localName, String qName) throws SAXException {

		super.endElement(uri, localName, qName);
	}

	@Override
	// 结束文件方法
    //只调用一次
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("文档解析完毕");
	}
	public List<student> getStudents (InputStream xmlstream) throws ParserConfigurationException, SAXException, IOException{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		SAXForXml sfx=new SAXForXml();
		parser.parse(xmlstream,sfx );
		return sfx.getStudents() ;
		
	}
    public List<student> getStudents(){
		return students;
    	
    }

}
