<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<h3>관리자 로그인</h3>
<%=URLDecoder.decode(request.getParameter("position"),"utf-8")%><br>
<%=URLDecoder.decode(request.getParameter("userID"),"utf-8") %>님 환영합니다.


<div>
파라미터값을 가져올 때, 값이 변수라면 name의 이름이 아닌 value명으로 가져와야 함

</div>




</body>
</html>