<%@page import="com.database.DBManage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.rowset.WebRowSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>近期新闻</title>
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
WebRowSet rs = DBManage.query("select * from news");

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
<h2>近期新闻</h2>
<br>
<a href="editNews.jsp">点击此处添加新文档</a><br>
<%if(pg==1){ %>
<a href="news.jsp?p=<%=pg%>">首页</a>
<%} 
//计算链接
if(pg>1){%>
<a href="news.jsp?p=<%=pg-1%>">上一页</a>
<%}
if(pg*items<count){
%>
<a href="news.jsp?p=<%=pg+1%>">下一页</a>
<%} 
if(pg*items>=count){
%>
<a href="news.jsp?p=<%=pg%>">尾页</a>
<%} %>
<hr>
</body>
<hr>
<table border="1" width="80%">
	<tr>
		<th>编号</th>
		<th>标题</th>
		<th>栏目</th>
		<th>日期</th>
		<th>作者</th>
		<th width="70">操作</th>
	</tr>
	
	<%
	while(rs.next() && rs.getRow()<=limit){
		String id=rs.getString("id");
		String title=rs.getString("title");
		String coln=rs.getString("coln");
		String date=rs.getString("date");
		String author=rs.getString("author");
	
	%>
	<tr>
		<td><%=id %></td>
		<td><%=title%></td>
		<td><%=coln%></td>
		<td><%=coln %></td>
		<td><%=author %></td>
		<td align="center">
			<a href="editNews.jsp?id=<%=id%>" onClick="return confirm('确定是否修改此条新闻')">
			修改
			</a>
			<a href="EditNews?id=<%=id%>" onClick="return confirm('确定是否删除此条新闻')">
			删除
			</a>
	<%
	}
	rs.close();
	%>
	
</table>

</html>