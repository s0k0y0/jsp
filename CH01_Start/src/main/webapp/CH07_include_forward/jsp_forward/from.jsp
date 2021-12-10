<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp::forward(179)</title>
</head>
<img src="jspForward.jㅔㅎ">
<body>
이 페이지는 from.jsp페이지 입니다1.<br>
<%
request.setAttribute("number", "1234");
%>
<jsp:forward page="to.jsp?name=hong">
<jsp:param value="abcd" name="id"/>
</jsp:forward>



이 페이지는 from.jsp페이지 입니다2<br>
<div>
include는 다시 메인 페이지로 돌아왔다면 forward는 다른 페이지에서 실행을 종료함
</div>


</body>
</html>