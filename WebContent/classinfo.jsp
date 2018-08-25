<%@page import="com.database.DBManage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.rowset.WebRowSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级列表</title>
</head>
<%
request.setCharacterEncoding("utf-8");
WebRowSet rs = DBManage.query("select * from class");
%>
<body>
<h2>用户列表</h2>
<a href="add2.jsp">创建新用户</a>
<hr>
<table border="1" width="80%">
	<tr>
		<th>编号</th>
		<th>学院</th>
		<th>专业</th>
		<th>班级名</th>
		<th>删除</th>
	</tr>
	
	<%
	while(rs.next()){
		String classnum=rs.getString("classnum");
		String academy=rs.getString("academy");
		String major=rs.getString("major");
		String classname=rs.getString("classname");
	%>
	<tr>
		<td><%=classnum %></td>
		<td><%=academy%></td>
		<td><%=major %></td>
		<td><%=classname %></td>
		<td align="center">
			<a href="edit2.jsp?classnum=<%=classnum%>" onClick="return confirm('确定是否修改当前记录')">
			修改
			</a>
			<a href="DelClass?classnum=<%=classnum%>" onClick="return confirm('确定是否删除当前记录')">
			删除
			</a>
	<%
	}
	rs.close();
	//stmt.close();
	//conn.close();
	%>
	
</table>
</body>
</html>