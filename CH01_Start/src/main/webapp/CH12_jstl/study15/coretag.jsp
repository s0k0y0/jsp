<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%

int[] core1=new int[10];
core1[0]=1;
core1[1]=2;
core1[2]=3;
core1[3]=4;
core1[4]=5;
core1[5]=6;
core1[6]=7;
core1[7]=8;
core1[8]=9;
core1[9]=10;

request.setAttribute("core01", core1);

ArrayList<String> core2=new ArrayList<>();
core2.add(0, "홍길동");
core2.add(1, "이순신");
core2.add(2, "유관신");
request.setAttribute("core02", core2);
%>


<%
for(int i=0; i<core1.length; i++){
	out.println(core1[i]+"<br>");
}

for(int i=0; i<core2.size(); i++){
	out.println(core2.get(i)+"<br>");
}


%>

<c:set var="core3" >
A<br>B<br>C<br>D<br>
</c:set>
${core3 }



</body>
</html>