
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%

Calendar cal=Calendar.getInstance();

%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendar클래스 사용</title>
</head>
<body>
<%=cal.get(Calendar.YEAR) %>년
<%=cal.get(Calendar.MONTH) %>월
<%=cal.get(Calendar.DATE) %>일 입니다.

</body>
</html>