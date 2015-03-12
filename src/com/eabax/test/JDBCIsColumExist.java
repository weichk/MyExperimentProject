package com.eabax.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
public class JDBCIsColumExist {
	private static String url = "jdbc:mysql://222.177.9.14:3306/openfire";  
    private static String user = "root";  
    private static String password = "jsp123456";  
    private static String driver = "com.mysql.jdbc.Driver"; 
    
	public static void main(String[] args) {
		try {
			Connection conn = null;
	        Class.forName(driver);  
	        conn = DriverManager.getConnection(url, user, password);  
	        conn.setAutoCommit(false);  
	        Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from aaaaa");
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for(int i=1;i<=columnCount;i++){
			    System.out.println(rsmd.getColumnName(i));
			    //rsmd.getColumnName(i)返回列名
			    //在这判断是不是存在你要找的列
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
