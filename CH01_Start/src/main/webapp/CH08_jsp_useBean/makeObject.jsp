<%@page import="Member.Memberinfo"%>
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
Memberinfo m1=new Memberinfo();
m1.setId("abcd");
System.out.println(m1.getId()+"<hr>");
%>

<jsp:useBean id="m2" class="Member.Memberinfo" scope="request"></jsp:useBean>

<!-- scrop:request 요청범위까지 허용? -->
<%
m2.setId("admin");
m2.setName("hong");
%>
<jsp:forward page="userObject.jsp"></jsp:forward>




</body>
</html>