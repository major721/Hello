<%@page import="com.database.DBManage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.rowset.WebRowSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示用户数据</title>
</head>
<%
request.setCharacterEncoding("utf-8");
WebRowSet rs = DBManage.query("select * from users");

%>
<body>
<h2>UPDATE</h2>

<hr>

	<%
	while(rs.next() ){
		String stunum=rs.getString("stunum");
		String pwd=rs.getString("pwd");
		pwd=com.abc.MD5.encrypt(pwd);
		out.println("update users set userpwd='"+pwd+"' where stunum='"+stunum+"';");
		out.println("<br>");
	%>
	
	<%
	}
	rs.close();
	//stmt.close();
	//conn.close();
	%>
	

</body>
</html>