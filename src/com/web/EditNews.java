package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DBManage;

/**
 * Servlet implementation class Editnews
 */
@WebServlet("/EditNews")
public class EditNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收数据
		String id=request.getParameter("id");
		
		//生成sql
		String sql="delete from news where id="+id;
		System.out.println("EditNews:doGet sql==>"+sql);

		int ret=DBManage.executeSql(sql);
		
		//返回页面
		response.sendRedirect("news.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String title=request.getParameter("title");
		String coln=request.getParameter("coln");
		String date=request.getParameter("date");
		String author=request.getParameter("author");
		String details=request.getParameter("details");
		String op=request.getParameter("op");
		String sql="";
		System.out.println("Editnews：doPost op==>"+op);
		
		if("edit".equals(op)) {
			//update
			//构造SQL:update
			sql="update news set title='"+title+"',coln='"+coln+"',date='"+date+"',author='"+author+"' where id='"+id+"'";
			System.out.println("Editnews：doPost sql==>"+sql);
		}else {
			sql="insert into news(title,coln,date,author,details) values('"+title+"','"+coln+"','"+date+"','"+author+"','"+details+"')";
			System.out.println("Editnews：doPost sql==>"+sql);
		}
		
		
		int ret=DBManage.executeSql(sql);
		
		//返回页面
		response.sendRedirect("news.jsp");
	}
	}


