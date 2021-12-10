<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp::include</title>
</head>
<body>
body_sub에서 name파라미터값::${param.name }<br>
name parameter 목록:<br>
<ul>
<%
String[] names=request.getParameterValues("name");
for(String name:names){
	out.println("<li>"+name+"</li>");
}
%>
</ul>
getparametervalues:배열을 출력할때 배열 값을 가져오기 위한 jsp문법

<hr>
request getAttribute::<%=request.getAttribute("name1") %>
</body>
</html>