<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
   
   request.setCharacterEncoding("utf-8");
   
   
   %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>request.getParameter() 사용</b><br>
name:<%=request.getParameter("name") %><br>
address:<%=request.getParameter("address") %><br>
출력하는 경우에 < % =을 붙이는 것 같음. 아닐 경우, 아무것도 안붙임 선언부의 !같은 느낌


<b>request.getParametervalues</b><br>
<%
String[] v=request.getParameterValues("pet");
if(v !=null){
	for(int i=0; i<v.length; i++){
	//out.println(v[i]);
%>
<%=v[i] %>
<% 
	}
}
%><br>
<b>request.getParameternames()</b><br>
<%
 Enumeration<String> paramEnum=request.getParameterNames();
while(paramEnum.hasMoreElements()){
	String name=paramEnum.nextElement();
	out.println(name+" "+"<br>");
}

%><br>

<b>request.getparametermap</b><br>
<%
 Map parameterMap=request.getParameterMap();
String[] nameParam=(String[])parameterMap.get("name");
if(nameParam !=null){
	out.println("name="+nameParam[0]);
}
%><br>



</body>
</html>