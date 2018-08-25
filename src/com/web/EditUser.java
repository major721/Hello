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
		//接收数据
				String stunum=request.getParameter("stunum");
				
				//生成sql
				String sql="delete from users where stunum="+stunum;
				System.out.println("DelUser:doGet sql==>"+sql);

				int ret=DBManage.executeSql(sql);
				
				//返回页面
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
		System.out.println("Edituser：doPost op==>"+op);
		
		if("edit".equals(op)) {
			//update
			//构造SQL:update
			sql="update users set stuname='"+stuName+"',pwd='"+userPwd+"',email='"+email+"',score='"+score+"' where stunum='"+stuNum+"'";
			System.out.println("Edituser：doPost sql==>"+sql);
		}else {
			sql="insert into users(stunum,stuname,pwd,email,score) values('"+stuNum+"','"+stuName+"','"+userPwd+"','"+email+"','"+score+"')";
			System.out.println("Edituser：doPost sql==>"+sql);
		}
		
		
		//执行数据写入DB操作
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			//获得与数据的连接
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeClass?useUnicode=true&characterEncoding=UTF-8","root","666666");
			Statement stmt=conn.createStatement();
			
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

	}

