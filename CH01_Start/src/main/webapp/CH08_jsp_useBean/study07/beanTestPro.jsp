<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bean" class="Member.TestBean"></jsp:useBean>
<jsp:setProperty property="name" name="bean"/>


<h1>자바빈을 사용하는 JSP페이지</h1>
입력된 이름은 <jsp:getProperty property="name" name="bean"/>입니다.


</body>
</html>