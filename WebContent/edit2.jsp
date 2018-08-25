<%@page import="com.database.DBManage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.rowset.WebRowSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改班级数据</title>
</head>
<%
//接收参数
String classnum=request.getParameter("classnum");
String academy,major,classname;
WebRowSet wrs = DBManage.query("select * from users where classnum="+classnum);
if(wrs.next()){
	academy=wrs.getString("academy");
	major=wrs.getString("major");
	classname=wrs.getString("classname");
}
wrs.close();
%>
<body>
<h2>用户信息修改</h2>
<hr>
<form action="EditClass" method="post">
<table border="0" >
	<tr>
		<td>编号：</td>
		<td><input type="text" name="classnum" value="<%=classnum%>" readonly></td>
	</tr>
	<tr>
		<td>学院：</td>
		<td><input type="text" name="academy" ></td>
	</tr>
	<tr>
		<td>专业：</td>
		<td><input type="text" name="major" ></td>
	</tr>
	<tr>
		<td>班级名：</td>
		<td><input type="text" name="classname" ></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="修改"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>