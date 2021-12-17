<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- 주소를 가서 찾아오는 것이 아니라 해당 도메인이라는 것을 식별하기 위한 식벽자 -->
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


${w[0]}<br>
${w[1]}<br>
${w[2]}<br>

<%

String[] a=(String[])request.getAttribute("w");
 
for(int i=0; i<a.length; i++){
	out.println(a[i]+"<br>");
}


ArrayList<String> a2 =(ArrayList<String>)request.getAttribute("a");
for(int i=0; i<a2.size(); i++){
	out.println(a2.get(i)+"<br>");
}
%>


${a[0] }명칭은 set에 저장된 변수명으로 작성한다<br>
${a[1] }<br>
${a[2] }<br>
${a[3] }<br>




//3.hashMap<br>
${NAME["hong1"] }value값이 아닌 key값을 넣음<br>
${NAME["hong2"] }<br>
${NAME["hong3"] }<br>
${NAME[NAME.hong1] }<br>
${NAME[NAME.hong2] }<br>
${NAME[NAME.hong3] }<br>

<%
HashMap<String,String> aa=(HashMap<String,String>)request.getAttribute("NAME");
for(int i=0; i<aa.size(); i++){
	out.println(aa.get("hong"+i)+"<br>");
}

//ketset():key의 집합에 있는 갯수만큼 반복문 실행하겠다
for(String key: aa.keySet() ){
	out.println(aa.get(key));
	
}
%>


//4.Member class 내용 출력
${MEM.id }<br>
${MEM.name }<br>


HashMap::JSTL<hr>
<c:forEach var="i" items="${NAME}">
	${i }<br>
</c:forEach>
<hr>



<c:forEach var="i" items="${NAME}">
	${entry.key }::${entry.value }
</c:forEach>
<hr>

ArrayList:JSTL<hr>
<c:forEach var="i" items="${a2 }}">
	${i }<br>
</c:forEach>
jstl:jsp을 간략히 하기 위한 라이브러리
<hr>



</body>
</html>