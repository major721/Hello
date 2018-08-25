<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校友注册</title>
</head>
<%
Class.forName("com.mysql.jdbc.Driver");
//获取与数据的连接
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2eeclass","root","666666");
Statement stmt=conn.createStatement();
String sql ="select * from school";
System.out.println("listuser.jsp sql:"+sql);

ResultSet rs = stmt.executeQuery(sql);
%>
<body>
<h2>校友注册</h2>
<form action="UserServlet" method="post">
<table border="0" >
		<tr>
		<td>学号：</td>
		<td><input type="text" name="snum"/></td>
	</tr>
	<tr>
		<td>姓名：</td>
		<td><input type="text" name="sname"/></td>
	</tr>
	<tr>
		<td>性别：</td>
		<td><select name="sex">
 			<option value="1" >男</option>
    		<option value="2" >女</option>
  			</select>
  		</td>
	</tr>
	<tr>
		<td>出生日期：</td>
		<td> <select name="ethnic">
 			<option value="1">汉族</option>
    		<option value="2">其他</option>
  			</select>
  		</td>
	</tr>
	<tr>
		<td>班级：</td>
		<td><input type="text" name="class"/></td>
	</tr>
	<tr>
		<td>所在地区：</td>
		<td> 
		<select name="city">
 			<option value="1">北京市</option>
    		<option value="2">成都市</option>
    		<option value="3">上海市</option>
    		<option value="4">广州市</option>
    		<option value="5">其他</option>
  		</select>
  		</td>
	</tr>	
	<tr>
	<td>电话：</td>
	<td><input type="text" name="tel"/></td>
  	</tr>
  	<tr>
	<td>手机：</td>
	<td><input type="text" name="mobile"/></td>
  	</tr>
  	<tr>
	<td>QQ：</td>
	<td><input type="text" name="qq"/></td>
  	</tr>
  	<tr>
	<td>MSN：</td>
	<td><input type="text" name="msn"/></td>
  	</tr>
  	<tr>
	<td>Email：</td>
	<td><input type="text" name="email"/></td>
  	</tr>
  	<tr>
	<td>工作单位：</td>
	<td><input type="text" name="work"/></td>
  	</tr>
  	<tr>
	<td>联系地址：</td>
	<td><input type="text" name="add"/></td>
  	</tr>
  	<tr>
	<td>个人说明：</td>
	<td><input type="text" name="other"/></td>
  	</tr>
  	<tr>
	<td colspan="2">
	<input type="submit" value="注册"/>
	</td>
	
</table>

</form>

</body>
</html>