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
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
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

				int ret=DBManage.executeSql(sql);
				
				//����ҳ��
				response.sendRedirect("listuser.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String stuNum=request.getParameter("stunum");
		String stuName=request.getParameter("stuname");
		String userPwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		String score=request.getParameter("score");
		String op=request.getParameter("op");
		String sql="";
		System.out.println("Edituser��doPost op==>"+op);
		
		if("edit".equals(op)) {
			//update
			//����SQL:update
			sql="update users set stuname='"+stuName+"',pwd='"+userPwd+"',email='"+email+"',score='"+score+"' where stunum='"+stuNum+"'";
			System.out.println("Edituser��doPost sql==>"+sql);
		}else {
			sql="insert into users(stunum,stuname,pwd,email,score) values('"+stuNum+"','"+stuName+"','"+userPwd+"','"+email+"','"+score+"')";
			System.out.println("Edituser��doPost sql==>"+sql);
		}
		
		
		//ִ������д��DB����
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			//��������ݵ�����
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeClass?useUnicode=true&characterEncoding=UTF-8","root","666666");
			Statement stmt=conn.createStatement();
			
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

