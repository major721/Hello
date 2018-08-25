package com.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBManage;

/**
 * Servlet implementation class DelUser
 */
@WebServlet("/DelUser")
public class DelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������
		String stunum=request.getParameter("stunum");
		
		//����sql
		String sql="delete from users where stunum="+stunum;
		System.out.println("DelUser:doGet sql==>"+sql);
		
		//ִ��ɾ��
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			//��������ݵ�����
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeClass?useUnicode=true&characterEncoding=UTF-8","root","666666");
			Statement stmt=conn.createStatement();
			System.out.println("DelUser:doGet sql==>"+sql);
			
			int ret =stmt.executeUpdate(sql);//Ӱ���������¼
			System.out.println("ִ�н��ret="+ret);

			stmt.close();
			conn.close();
			
		}catch(ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/
		
		int ret=DBManage.executeSql(sql);
		
		//����ҳ��
		response.sendRedirect("listuser.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
