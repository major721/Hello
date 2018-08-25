<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.swufe.Advice" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%
String height=request.getParameter("height");
String weight=request.getParameter("weight");
System.out.println("height="+height+"weight="+weight);

%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
Advice a = new Advice();
float bmi=a.showBmi(height,weight);
if(bmi<18.5) {System.out.println("您的BMI指数为："+bmi);
out.println("您的体重太轻了，多吃点东西吧！");
}else if(bmi<24) {System.out.println("您的BMI指数为："+bmi);
out.println("您的体重是正常的哦，继续保持！");
}else if(bmi<27) {System.out.println("您的BMI指数为："+bmi);
out.println("您的体重有点重了哦，多多锻炼吧！");

}else if(bmi<32) {System.out.println("您的BMI指数为："+bmi);
out.println("您肥胖了，控制饮食，加强锻炼！");
}else {System.out.println("您的BMI指数为："+bmi);
out.println("您非常肥胖了，引起注意减减肥咯!");
}

%>
<body>
</body>
</html>