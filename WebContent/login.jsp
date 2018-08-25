<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
System.out.println(" form login.jsp");
%>
<body>
<h2>欢迎使用</h2>
<form action="LoginServlet" method="post">
<table width="300" border="0">
	<tr>
		<td>用户名：</td>
		<td><input type="text" name="username" /></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><input type="text" name="pwd" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="登录"></td>
	</tr>
</table>
</form>

</body>
</html>