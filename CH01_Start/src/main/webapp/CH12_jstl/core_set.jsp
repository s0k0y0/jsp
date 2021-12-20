<%@page import="java.util.HashMap"%>
<%@page import="ch11_el.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <%
    Member m=new Member();
    HashMap<String, String> hm=new HashMap<>();
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="member" value="<%=m %>"> </c:set>
jsp에서 선언된 변수는 반드시 jsp로 호출될 수 밖에 없다???<br>
<c:set target="${member }" property="name" value="홍길동"></c:set>
주소값이 들은 m변수가 담긴 member를 타깃으로 설정 그 안에 name이라는 변수에 홍길동이라는 값을 넣겠다<br>

<c:set var="pref" value="<%=hm %>"></c:set>
<c:set var="favoriateColor" value="#{pref.color }"></c:set>

회원이름:: ${member.name }<br>
좋아하는 색1:: ${favoriateColor }<br>
<c:set target="${pref }" property="color" value="red"></c:set>
설정 이후 좋아하는 색2:: ${favoriateColor }<br>

</body>
</html>