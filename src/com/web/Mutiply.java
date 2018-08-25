package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mutiply extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		for(int i = 1; i <=9; i++) {
			for(int j = 1; j <= 9;j ++){ 
				out.print(i+"*"+j+"="+i*j+"<br>");
				
			}
		}
		out.flush();
		out.close();
	}

}
