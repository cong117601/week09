package com.yunhe.day01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Generate {
	public static void main(String[] args) throws Exception {
		createBeen("com.yunhe.day01", "Student");
	}

	public static void createBeen(String PackagePath, String tableName) {
		String BeenName = FirstCharUpperCase(tableName);
		String replace = PackagePath.replace(".", "/");
		File fd = new File("src/" + replace);
		fd.mkdirs();
		String path = "src/" + replace + "/" + BeenName + ".java";

		File f = new File(path);
		System.out.println(BeenName+"类生成绝对路径："+f.getAbsolutePath());
 
		try {
			f.createNewFile();
			FileWriter fw = new FileWriter(f, false);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("package " + PackagePath + ";");
			bw.write("import java.io.*;import java.util.*;");
			bw.newLine();
			bw.write("public class " + BeenName + " implements Serializable{");
			bw.newLine();
			HashMap<String, String> fieldMap = getField(tableName);
			String toString = "\"" + FirstCharUpperCase(tableName) + " [";
			for (String fielfName : fieldMap.keySet()) {
				String string = fieldMap.get(fielfName);// 数据库字段属性
				String field = "";
				bw.write("private ");
				if ("VARCHAR".equals(string) || "CHAR".equals(string) || "TEXT".equals(string)) {
					field = "String";
				} else if ("INT".equals(string)) {
					field = "int";
				} else if ("DATETIME".equals(string) || "DATE".equals(string) || "TIME".equals(string)) {
					field = "Date";
				}else if ("DOUBLE".equals(string)) {
					field = "double";
				}

				bw.write(field + " " + fielfName + ";");
				bw.newLine();
				toString += fielfName + "\"" + "+ this." + fielfName + "+\"";
				bw.write("public " + field + " get" + FirstCharUpperCase(fielfName) + "(){return this." + fielfName
						+ ";}");
				bw.newLine();
				bw.write("public void set" + FirstCharUpperCase(fielfName) + "(" + field + " " + fielfName + "){this."
						+ fielfName + "=" + fielfName + ";}");
				bw.newLine();

			}
			toString += "]\";";
			bw.write("@Override");
			bw.newLine();
			bw.write("public String toString() {");
			bw.newLine();
			bw.write(" return " + toString + " }");
			bw.newLine();
			bw.write("}");
			bw.flush();
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static HashMap<String, String> getField(String tableName) {
		HashMap<String, String> columnNameMap = new HashMap<>(); // 保存字段名
		try {
			// 获取连接
			Connection connection = AiUtil.getConnection();
			// 获得元数据
			DatabaseMetaData metaData = connection.getMetaData();
			// 通过表名获得所有字段名
			ResultSet columns = metaData.getColumns(null, null, tableName, "%");

			// 获得所有字段名
			while (columns.next()) {
				// 获得字段名
				String column_name = columns.getString("COLUMN_NAME");
				// 获得字段类型
				String type_name = columns.getString("TYPE_NAME");

				columnNameMap.put(column_name, type_name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("数据库字段");
		for (String string : columnNameMap.keySet()) {
			
			System.out.println("字段名："+string + "\t数据库类型：" + columnNameMap.get(string));
		}
		return columnNameMap;
	}
	
	//将字符串首字母大写
	public static String FirstCharUpperCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
