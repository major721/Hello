<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#stunum").blur(function(){
		var str=$(this).val();
		
	$.post("CheckStunum",{stunum:str},function(result){
		if(result==1){
			//用户已存在，提示
			$("#tip").html("当前用户已存在");
			$(":submit").attr('disabled','disabled');
		}else{
			//可以使用
			$("#tip").html("");
			$(":submit").removeAttr('disabled');
		}
	})
	});
});
</script>
<title>新增用户</title>
</head>
<body>
<h2>新增用户</h2>
<hr>
<form action="AddUser" method="post">
<table border="0" >
	<tr>
		<td>学号：</td>
		<td><input type="text" name="stunum" ><span id="tip" color="red"></span></td>
	</tr>
	<tr>
		<td>姓名：</td>
		<td><input type="text" name="stuname" ></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><input type="text" name="pwd" ></td>
	</tr>
	<tr>
		<td>email：</td>
		<td><input type="text" name="email" ></td>
	</tr>
	<tr>
		<td>成绩：</td>
		<td><input type="text" name="score" ></td>
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