<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.swufe.Checker"%>
<%@ page import="com.abc.MD5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
request.setCharacterEncoding("utf-8");
String userName=request.getParameter("username");
String userPwd=request.getParameter("pwd");
System.out.println("userName="+userName+"userPwd="+userPwd);

%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
//java/tomcat
/*if("java".equals(userName)&&"tomcat".equals(userPwd)){
	out.print("OK");
}else{
	out.print("Error");
} */

Checker checker = new Checker();
boolean c = checker.validate(userName,userPwd);
if(c==true){
	out.print("OK");
}else{
	out.print("Error");
	System.out.print("登录失败");
	//转入登录页面
	response.sendRedirect("login.jsp?err=1");
} 
%>
<br>
<%String userName1= MD5.encrypt(userName);
String userPwd1= MD5.encrypt(userPwd);
out.println("用户名加密："+userName1);
out.println("用户密码加密："+userPwd1); %>


<h2>收到的数据</h2>
<hr>
用户：<%=userName %>
密码：<%out.print(userPwd); %>
</body>
</html>