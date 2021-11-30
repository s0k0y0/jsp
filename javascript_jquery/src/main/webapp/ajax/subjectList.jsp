<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

String[] sub={"JAVA","Oracle","Web","JSP","Spring"};
 
for(int i=0; i<sub.length; i++){
	//document.write(sub[i]);
}

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<%
	for(String s: sub){
		System.out.println(s);
%>
<li><%=s %></li>
<% 
	}
%>
</ul>
</body>
</html>