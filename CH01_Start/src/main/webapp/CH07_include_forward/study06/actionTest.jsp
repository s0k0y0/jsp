<%@page import="java.net.URLEncoder"%>
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
String userID=request.getParameter("userID");
String userPass=request.getParameter("userPass");
String loginCheck=request.getParameter("loginCheck");
%>
<%
if(loginCheck.equals("user")){
	%>
	<jsp:forward page="userMain.jsp">
	<jsp:param value='<%=URLEncoder.encode("전고객","utf-8") %>' name="position"/>
	<jsp:param value="userID" name="ID"/>
	</jsp:forward>
	<%
} else{
	
	%>
	<jsp:forward page="managerMain.jsp">
	<jsp:param value='<%=URLEncoder.encode("관리자","utf-8") %>' name="position"/>
	<jsp:param value="userID" name="ID"/>
	</jsp:forward>
	<%
}



%>

urlencoder:한글 깨짐을 막기 위해 문자열만 입력할 수 있다

</body>
</html>