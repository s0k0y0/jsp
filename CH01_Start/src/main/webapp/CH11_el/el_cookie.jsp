<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Cookie c = new Cookie("MyCookie", "admin");
c.setMaxAge(60 * 60);
response.addCookie(c);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL:: Cookie</title>
</head>
<body>
	MyCookie 값:: ${cookie.MyCookie.value }
	<br> MyCookie 값:: ${cookie['MyCookie']['value'] }
	<br> MyCookie 유지시간:: ${cookie.MyCookie.maxAge }
	<br>


</body>
</html>