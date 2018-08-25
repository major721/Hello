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
//获取页码
int items=5;
int pg=1;
String p=request.getParameter("p");
if(p!=null&&p.length()>0){
	pg=Integer.parseInt(p);
}

WebRowSet rs = DBManage.query("select * from users");

//计算起始位置和结束位置
rs.last();
int count=rs.getRow();

int start=(pg-1)*items;
int limit=pg*items<count?pg*items:count;
if(start>0){
	rs.absolute(start);
}else{
	rs.beforeFirst();
}
%>
<body>
<h2>用户列表</h2>
<a href="adduser.jsp">创建新用户</a>
<%
out.println(count);
out.println("<br>");
out.println(start+"-"+limit);
%>
<hr>
<table border="0.8" width="80%">
	<tr>
		<th>学号</th>
		<th>姓名</th>
		<th>密码</th>
		<th>email</th>
		<th width="70">操作</th>
	</tr>
	
	<%
	while(rs.next() && rs.getRow()<=limit){
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
			<a href="DelUser?stunum=<%=stunum%>" onClick="return confirm('确定是否删除当前记录')">
			删除
			</a>
	<%
	}
	rs.close();
	//stmt.close();
	//conn.close();
	%>
	
</table>
<%
//计算链接
if(pg>1){%>
<a href="liststu.jsp?p=<%=pg-1%>">上一页</a>
<%}
if(pg*items<count){
%>
<a href="liststu.jsp?p=<%=pg+1%>">下一页</a>
<%} %>
</body>
</html>