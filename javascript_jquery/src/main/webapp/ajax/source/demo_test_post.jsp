<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String name=request.getParameter("name");
    String city=request.getParameter("city");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Dear <%=name %>.Hope you live well in<%=city %>
</body>
</html>