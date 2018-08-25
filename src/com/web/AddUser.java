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
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//�������ݵ����ݿ�
		//��������
		String stuNum=request.getParameter("stunum");
		String stuName=request.getParameter("stuname");
		String userPwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String score=request.getParameter("score");
		
		//����SQL:update
		String sql="insert into users(stunum,stuname,pwd,email,score) values('"+stuNum+"','"+stuName+"','"+userPwd+"','"+email+"','"+score+"')";
		//ִ������д��DB����
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			//��������ݵ�����
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeClass?useUnicode=true&characterEncoding=UTF-8","root","666666");
			Statement stmt=conn.createStatement();
			System.out.println("AddUser:doPost sql==>"+sql);
			
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

	}


