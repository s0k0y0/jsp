<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    session.setAttribute("id",request.getParameter("id"));
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 되었습니다.</h1>
<h4>로그인 아이디:<%=session.getAttribute("id") %></h4>
<a href="sessionLogout.jsp?id2=abcd&pw2=1234">로그아웃</a>



</body>
</html>