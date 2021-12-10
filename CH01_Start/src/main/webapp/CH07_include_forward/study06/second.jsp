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
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String position = request.getParameter("position");

	if (id.equals("admin")) {
		if (pass.equals("1234")) {
		if (position.equals("manager")) {
	%>

	<jsp:forward page="third.jsp">
		<jsp:param name="id" value="id" />
		<jsp:param  name="pass" value="pass"/>
		<jsp:param name="position" value="position"  />
	</jsp:forward>


	<%
			}
		}
	}

	
	if (id.equals("abcd")) {
	if (pass.equals("1111")) {
	if (position.equals("user")) {
	%>


	<jsp:forward page="four.jsp">
		<jsp:param name="id" value="id" />
		<jsp:param name="pass" value="pass"/>
		<jsp:param name="position" value="position" />

	</jsp:forward>


	<%
			}
		}
	}
	%>

<%=id %>
<%=pass %>
<%=position %>

	
	<!-- 관리자 id:admin password:1234 사용자 id:abcd password:1111 -->



</body>
</html>