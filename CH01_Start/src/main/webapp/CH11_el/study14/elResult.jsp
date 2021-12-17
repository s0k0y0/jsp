<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String val1= application.getInitParameter("name");
String val2= application.getInitParameter("age");
out.println("Name:"+val1+"<br>"+"age:"+val2);

%>
초기화Parameter Name: ${initParam.Name }<br>
초기화Parameter age: ${initParam.age }<br>
<hr>
요청 URI:${pageContext.request.requestURI }<br>
요청 URI:<%=request.getRequestURI() %><br>

<br>
아이디: %{param.id }<br>
${paramValues.sports[0] }<br>
${paramValues.sports[1] }<br>
${paramValues.sports[2] }<br>
${paramValues.sports[3] }<br>





</body>
</html>