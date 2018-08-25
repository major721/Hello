<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增班级</title>
</head>
<body>
<h2>新增班级</h2>
<hr>
<form action="AddClass" method="post">
<table border="0" >
	<tr>
		<td>编号：</td>
		<td><input type="text" name="classnum" ></td>
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
		<input type="submit" value="保存"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>