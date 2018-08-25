package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.WebRowSet;

import com.sun.rowset.WebRowSetImpl;

public class DBManage {
	//获得jdbc连接
	public static Connection getConnection(){
		Connection conn=null;
		try {
			//Oracle连接方式：Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
			//获得与数据的连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeClass?useUnicode=true&characterEncoding=UTF-8","root","666666");
			//Oracle：conn=DriverManager.getConnection("jdbc:oracle:thin:@10.8.131.12:1521:ORCL","stu2","111")
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static WebRowSet query(String sql) {
		//WebRowSet（引入另一种结果集,因为rs在conn关闭之后就没有结果了）
		WebRowSet wrs=null;
		Connection conn=getConnection();
		Statement stmt;
		try {
			wrs=new WebRowSetImpl();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			wrs.populate(rs);
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wrs;
	}
	
	public static int executeSql(String sql) {
		int retVal=0;
		try {
			//获得与数据的连接
			Connection conn=getConnection();
			Statement stmt=conn.createStatement();
			System.out.println("DBManage=>executeSql sql"+sql);
			
			retVal=stmt.executeUpdate(sql);//影响多少条记录
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("DBManage=>executeSql"+retVal);
		return retVal;
	}
	
}
