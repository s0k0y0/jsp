<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
%@ includer.jsp를 사용할 경우:공유 변수 사용시<br>
<img src="directiveInclude.jpg"><br>

<%
int number=10;
%>

<%@ include file="includee.jspf"%><!-- sub페이지의 코드를 복붙해서 실행되게 함 -->




공통변수 DATAFOLDER="<%=dataFolder %>"

</body>
</html>