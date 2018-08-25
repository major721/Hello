package com.swufe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Checker {
	public boolean validate(String userName,String userPwd) {
//		System.out.println("Checker.validate()......");
//		if("java".equals(userName)&&"major".equals(userPwd)){
//			System.out.print("OK");
//			return true;
//		}else{
//			return false;
//		}
//		
		
		//用数据库做验证
		boolean retval=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
			//连接数据库
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/j2eeclass", "root", "666666");
			//通过Statement执行sql语句
			Statement stmt=conn.createStatement();
			String sql="select * from users where stunum='"+userName+"'and userpwd='"+userPwd+"'";
			System.out.println("Checker==>validate sql="+sql);
			
			//通过结果集判断是否有数据
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				retval=true;
			}
			//关闭连接资源
			rs.close();
			stmt.close();
			conn.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retval;
	}
}
