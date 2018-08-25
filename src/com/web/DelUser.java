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
		//接收数据
		String stunum=request.getParameter("stunum");
		
		//生成sql
		String sql="delete from users where stunum="+stunum;
		System.out.println("DelUser:doGet sql==>"+sql);
		
		//执行删除
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			//获得与数据的连接
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeClass?useUnicode=true&characterEncoding=UTF-8","root","666666");
			Statement stmt=conn.createStatement();
			System.out.println("DelUser:doGet sql==>"+sql);
			
			int ret =stmt.executeUpdate(sql);//影响多少条记录
			System.out.println("执行结果ret="+ret);

			stmt.close();
			conn.close();
			
		}catch(ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}*/
		
		int ret=DBManage.executeSql(sql);
		
		//返回页面
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
