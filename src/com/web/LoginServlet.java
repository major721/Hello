package com.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swufe.Checker;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/jsp/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("init:==>init()");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet:==>doGet()");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy:==>destroy()");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("username");
		String userPwd=request.getParameter("pwd");
		System.out.println("doPost:==>doPost()");
		System.out.println("userName="+userName+"userPwd="+userPwd);
		Checker checker = new Checker();
		boolean c = checker.validate(userName,userPwd);
		if(c==true){
			response.sendRedirect("welcome.jsp");
		}else{
			System.out.print("Error");
			System.out.print("µÇÂ¼Ê§°Ü");
			//×ªÈëµÇÂ¼Ò³Ãæ
			//response.sendRedirect("login.jsp?");
			request.getSession().setAttribute("stunum",userName);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} 
			
	}

}
