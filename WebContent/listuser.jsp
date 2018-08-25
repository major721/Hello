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
String key=request.getParameter("keyword");
//Class.forName("com.mysql.jdbc.Driver");
//获取与数据的连接
//Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeclass","root","666666");
/*
Connection conn=DBManage.getConnection();
String sql ="select * from users";
Statement stmt=conn.createStatement();
if(key!=null && key.length()>0){
	sql+=" where stunum like '%"+key+"%' or stuname like '%"+key+"%'";
}
System.out.println("listuser.jsp sql:"+sql); 
ResultSet rs = stmt.executeQuery(sql);*/
WebRowSet rs = DBManage.query("select * from users");
%>
<body>
<h2>用户列表</h2>
<form method="post">
<input type="text" name="keyword" value="<%=key!=null?key:""%>">
<input type="submit" value="查找">
</form>
<a href="edituser.jsp">创建新用户</a>
<hr>
<table border="1" width="80%">
	<tr>
		<th>学号</th>
		<th>姓名</th>
		<th>密码</th>
		<th>email</th>
		<th width="70">操作</th>
	</tr>
	
	<%
	while(rs.next()){
		String stunum=rs.getString("stunum");
		String stuname=rs.getString("stuname");
	
	%>
	<tr>
		<td><%=stunum%></td>
		<td><%=stuname %></td>
		<td><%=rs.getString("pwd") %></td>
		<td><%=rs.getString("email") %></td>
		<td align="center">
			<a href="edituser.jsp?stunum=<%=stunum%>" onClick="return confirm('确定是否修改当前记录')">
			修改
			</a>
			<a href="EditUser?stunum=<%=stunum%>" onClick="return confirm('确定是否删除当前记录')">
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