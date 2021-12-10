<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp::forward(180)</title>
</head>
<body>
to.jsp페이지입니다<br>
<img src="jspForward.jpg"><br>
<%=request.getParameter("id") %><br>
${param.id }<br>
<%=request.getAttribute("number") %><br>
${number }<br>
<%=request.getParameter("name") %><br>

</body>
</html>