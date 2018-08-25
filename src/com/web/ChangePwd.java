package com.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.MD5;

/**
 * Servlet implementation class ChangePwd
 */
@WebServlet("/ChangePwd")
public class ChangePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePwd() {
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
		//获取用户数据
		String stunum=request.getParameter("stunum");
		String oldpwd=request.getParameter("oldpwd");
		String pwd1=request.getParameter("pwd1");
		String pwd2=request.getParameter("pwd2");
		
		//查询原始密码
		String sql="select * from users where stunum='"+stunum+"' and pwd='"+oldpwd+"'";
		javax.sql.rowset.WebRowSet rs=com.database.DBManage.query(sql);
		try {
			if(rs.next()) {
				//修改密码
				if(pwd1==pwd2) {
					sql="update users set pwd='"+MD5.encrypt(pwd2)+"' where stunum='"+stunum+"'";
					com.database.DBManage.query(sql);
					//返回登录页面
					response.sendRedirect("login.jsp");
				}else {
					response.sendRedirect("changePwd.jsp?err=2");
				}
			}else {
				//原始密码不正确
				response.sendRedirect("changePwd.jsp?err=1");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
