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
		
		//�����ݿ�����֤
		boolean retval=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");//�������ݿ�����
			//�������ݿ�
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/j2eeclass", "root", "666666");
			//ͨ��Statementִ��sql���
			Statement stmt=conn.createStatement();
			String sql="select * from users where stunum='"+userName+"'and userpwd='"+userPwd+"'";
			System.out.println("Checker==>validate sql="+sql);
			
			//ͨ��������ж��Ƿ�������
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
				retval=true;
			}
			//�ر�������Դ
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
