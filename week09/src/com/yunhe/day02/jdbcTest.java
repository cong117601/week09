package com.yunhe.day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcTest {
	public static void main(String[] args) {
		//注册驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		// 获取连接对象
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "123456");
		//创建预编译对象
			Statement createStatement = con.createStatement();
		//编写sql
			String  sql="select * from teacher";
			ResultSet executeQuery = createStatement.executeQuery(sql);
			while(executeQuery.next()){
				String string = executeQuery.getString(1);
				String string2 = executeQuery.getString(2);
				System.out.println(string+string2);
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
