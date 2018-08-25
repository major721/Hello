<%@page import="com.swufe.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="tom" class="com.swufe.Student" scope="page"></jsp:useBean>
<title>JavaBean</title>
</head>
<body>
<h2>JavaBean</h2>
<form method="post">
	stunum<input type="text" name="stunum" value="stunum"/><br>
	pwd<input type="text" name="pwd" value="pwd"/><br>
	pwd2<input type="text" name="pwd2" value="pwd2"/><br>
	<input type="submit" value="提交"/>
</form>
<hr>
获取的数据:
<jsp:setProperty property="stunum" name="tom"/>
<jsp:setProperty property="pwd" name="tom" value="pwd2"/>

<%
out.println(request.getParameter("stunum"));
out.println(request.getParameter("pwd"));
out.println("<br><hr>");

//Student tom= new Student();//这句话用useBean那句话实现了
//tom.setStunum(request.getParameter("stunum")); 这句话用setProperty那句话实现了
//tom.setPwd(request.getParameter("pwd"));


Student stu= new Student();
stu.setStunum(request.getParameter("stunum"));
stu.setPwd(request.getParameter("pwd"));
out.println(tom.getStunum());
out.println(tom.getPwd());

%>
<hr>
<jsp:getProperty property="stunum" name="tom"/>
</body>
</html>