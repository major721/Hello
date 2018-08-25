<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>欢迎使用</h2>
<form action="showBmi.jsp" method="post">
<table width="300" border="0">
	<tr>
		<td>身高：</td>
		<td><input type="text" name="height" value="1.6" /></td>
	</tr>
	<tr>
		<td>体重：</td>
		<td><input type="text" name="weight" value="50.5" /></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="确定"></td>
	</tr>
	<tr>
		<td>体重：</td>
		<td><input type="text" name="weight" /></td>
	</tr>
</table>
</form>

</body>
</html>