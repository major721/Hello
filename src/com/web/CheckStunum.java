package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import com.database.DBManage;

/**
 * Servlet implementation class CheckStunum
 */
@WebServlet("/CheckStunum")
public class CheckStunum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckStunum() {
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
		String stunum=request.getParameter("stunum");
		//获取当前输入，判断是否已被注册
		String sql="select * from users where stunum='"+stunum+"'";
		String retVal="0";
		WebRowSet rs =DBManage.query(sql);
		try {
			if(rs.next()) {
				retVal="1";
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.println(retVal);
		System.out.println("retVal"+retVal);
		out.flush();
		out.close();
		
	}

	
}
