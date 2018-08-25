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
@WebServlet("/EditClass")
public class EditClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClass() {
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
		String classnum=request.getParameter("classnum");
		String classname=request.getParameter("classname");
		String academy=request.getParameter("academy");
		String major=request.getParameter("major");
		
		//构造SQL:update
		String sql="update class set academy='"+academy+"',major='"+major+"',classname='"+classname+"' where classnum='"+classnum+"'";
		System.out.println("EditClass：doPost sql==>"+sql);
		
		int ret=DBManage.executeSql(sql);
		
		//返回页面
		response.sendRedirect("classinfo.jsp");
	}

	}

