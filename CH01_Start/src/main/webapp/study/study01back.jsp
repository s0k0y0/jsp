<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");


String classes=request.getParameter("classes");
String name=request.getParameter("name");
String grade=request.getParameter("grade");
String subject=request.getParameter("subject");
%>

<%!

public String student (String classes, String name, String grade, String subject){
	
	String t="<table border=1>";
	t=t+"<tr><td>학번</td><td>"+classes+"</td></tr>";
	t=t+"<tr><td>이름</td><td>"+name+"</td></tr>";
	t=t+"<tr><td>학년</td><td>"+grade+"</td></tr>";
	t=t+"<tr><td>선택과목</td><td>"+subject+"</td></tr>";
	t=t+"</table>";
	return t;
}




%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=student(classes,name,grade,subject) %>

<%out.println(student(classes,name,grade,subject)); %>

<%=student("a","a","2학년","java") %>




</body>
</html>