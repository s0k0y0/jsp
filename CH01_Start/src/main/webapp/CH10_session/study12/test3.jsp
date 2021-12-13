
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
//request.getSession();//현재 세선이 존재하면 기존세션 리턴, 없으면 null값 리턴
session=request.getSession(false);
if(session !=null){
	session.invalidate();
	response.sendRedirect("index.jsp");
}
%>



</body>
</html>