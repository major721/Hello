package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		//������д�����ݿ�
		//��ȡ�û���������
		String snum=request.getParameter("snum");//���������valueֵһ��
		String sname=request.getParameter("sname");
		String sex= request.getParameter("sex");
		String email= request.getParameter("email");
		String birthdate=request.getParameter("birthdate");
		String ethnic=request.getParameter("ethnic");
		String sclass=request.getParameter("class");
		String city=request.getParameter("city");
		String tel=request.getParameter("tel");
		String qq=request.getParameter("qq");
		String mobile=request.getParameter("mobile");
		String msn=request.getParameter("msn");
		String work=request.getParameter("work");
		String add=request.getParameter("add");
		String other=request.getParameter("other");
		
		//����SQL insert into......
		String sql="INSERT INTO users VALUES('"+snum+"','"+sname+"','"+sex+"','"+birthdate+"','"+ethnic+"','"+sclass+"','"+city+"','"+tel+"','"+mobile+"','"+qq+"','"+msn+"','"+email+"','"+work+"','"+add+"','"+other+"');";
		
		//ִ������д��DB����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//��������ݵ�����
			Connection conn=DriverManager.getConnection("jbdc:mysql//localhost:3306/j2eeClass?useUnicode=true&characterEncoding=UTF-8","root","666666");
			Statement stmt=conn.createStatement();
			
			int ret =stmt.executeUpdate(sql);//Ӱ���������¼
			System.out.println("ִ�н��ret="+ret);

			stmt.close();
			conn.close();
			
		}catch(ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//����ҳ��
		response.sendRedirect("school.jsp");
	}

}
