package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBManage;

/**
 * Servlet implementation class AddClass
 */
@WebServlet("/AddClass")
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClass() {
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
		//保存数据到数据库
		//接收数据
		String classnum=request.getParameter("classnum");
		String academy=request.getParameter("academy");
		String major=request.getParameter("major");
		String classname=request.getParameter("classname");
		
		String sql="insert into class(classnum,academy,major,classname) values('"+classnum+"','"+academy+"','"+major+"','"+classname+"')";
	
		int ret=DBManage.executeSql(sql);
		
		//返回页面
		response.sendRedirect("classinfo.jsp");
	
	}

}
