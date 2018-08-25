<%@page import="com.database.DBManage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户数据</title>
</head>
<%
//接收参数
String stunum=request.getParameter("stunum");
String userName="",userPwd="",email="",score="",userNum="",readonlyStr="",lable="新增",op="add";

if(stunum!=null&&stunum.length()>0){
	//修改
	op="edit";
	readonlyStr="readonly";
	lable="修改";
	//sql获取当前用户数据
	String sql="select * from users where stunum="+stunum;
	System.out.println("edituser.jsp sql:"+sql);
	javax.sql.rowset.WebRowSet rs=DBManage.query(sql);

	if(rs.next()){
		userNum=rs.getString("stunum");
		userName=rs.getString("stuname");
		userPwd=rs.getString("pwd");
		email=rs.getString("email");
		score=rs.getString("score");
	}
	rs.close();
}else{
	stunum="";
}

%>
<body>
<h2><%=lable %>用户</h2>
<hr>
<form action="EditUser" method="post">
<table border="0" >
	<tr>
		<td>学号：</td>
		<td><input type="text" name="stunum" value="<%=userNum%>" <%=readonlyStr %>></td>
	</tr>
	<tr>
		<td>姓名：</td>
		<td><input type="text" name="stuname" value="<%=userName %>"></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><input type="text" name="pwd" value="<%=userPwd %>"></td>
	</tr>
	<%if(stunum.length()==0) {%>
	<tr>
		<td>邮箱：</td>
		<td><input type="text" name="email" value="<%=email%>"></td>
	</tr>
	<% }%>
	<tr>
		<td>成绩：</td>
		<td><input type="text" name="score" value="<%=score %>"></td>
	</tr>	
	<tr>
		<td colspan="2">
		<input type="submit" value="修改"/>
		</td>
	</tr>
</table>
<input type="hidden" name="op" value="<%=op%>"/>
</form>
</body>
</html>