<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.rowset.WebRowSet" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>在线捐赠</h2>
<form action="Donate" method="post">
捐赠人:<input type="text" name="donor"><br>
捐赠金额:<input type="text" name="money"><br>
所在班级:
	<select name="class">
 			<option value="1">国贸1班</option>
    		<option value="2">汉语1班</option>
    		<option value="3">计科1班</option>
    		<option value="4">信管1班</option>
  	</select>
<br>
附言：<br>
<textarea rows="5" cols="40" name="other"></textarea>
<br>
<input type="submit" value="提交">
</form>
</body>
</html>