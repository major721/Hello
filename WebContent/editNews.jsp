<%@page import="com.database.DBManage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文档详细信息</title>
</head>
<%
//接收参数
String id=request.getParameter("id");
String title="",coln="",author="",date="",details="",op="add";

if(id!=null&&id.length()>0){
	//修改
	op="edit";
	//sql获取当前用户数据
	String sql="select * from news where id="+id;
	System.out.println("editnews.jsp sql:"+sql);
	javax.sql.rowset.WebRowSet rs=DBManage.query(sql);

	if(rs.next()){
		title=rs.getString("title");
		coln=rs.getString("coln");
		date=rs.getString("date");
		details=rs.getString("details");
		author=rs.getString("author");
	}
	rs.close();
}

%>
<body>
<h2>文档详细信息</h2>
<hr>
<form action="EditNews" method="post">
<table border="0" >
<tr>
	<td>标题</td>
	<td><input type="text" name="title" value=<%=title %>></td>
</tr>

<tr>
	<td>作者</td>
	<td><input type="text" name="author" value=<%=author %>></td>
</tr>

<tr>
<td>栏目</td>
	<td><select name="col">
 			<option >服务</option>
    		<option >动态</option>
  		</select>
  	</td>
</tr>
<tr>
	<td>文档内容</td>
	<td><textarea name="details" rows="5" cols="50" value=<%=details %>></textarea></td>
</tr>
<tr>
	<td><input type="submit" value="确认提交">
	</td>
</tr>
</table>
<input type="hidden" name="op" value="<%=op%>"/>
<input type="hidden" name="id" value="<%=id%>"/>
</form>
</body>
</html>