package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBManage;

/**
 * Servlet implementation class Donate
 */
@WebServlet("/Donate")
public class Donate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Donate() {
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
		String donor=request.getParameter("donor");
		String money=request.getParameter("money");
		String donorclass=request.getParameter("class");
		String other=request.getParameter("other");
		
		String sql="insert into donation(donor,money,class,other) values ('"+donor+"','"+money+"','"+donorclass+"','"+other+"')";
	
		int ret=DBManage.executeSql(sql);
	
		response.sendRedirect("donation.jsp");
	}

}
