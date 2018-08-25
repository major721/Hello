<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String err=request.getParameter("err");
%>
<form action="ChangePwd" method="post">
请输入原始密码：<input type="password" name="oldpwd"/><br>
请输入新密码：<input type="password" name="pwd1"/><br>
请确认新密码：<input type="password" name="pwd2"/><br>
<input type="hidden" name="stunum" value=<%=session.getAttribute("stunum") %>>
<input type="submit" value="修改">
</form>

<%
if(err!=null && "1".equals(err)){
	out.println("原始密码不正确");
}
if(err!=null && "2".equals(err)){
	out.println("两次密码不相等");
}
%>
</body>
</html>