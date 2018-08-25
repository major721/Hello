<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
request.setCharacterEncoding("utf-8");
String userName=request.getParameter("username");
String userPwd=request.getParameter("pwd");
System.out.println("welcome.jsp------");
System.out.println("userName="+userName+"userPwd="+userPwd);
%>
<body>
<h1>Welcome!</h1>
</body>
</html>