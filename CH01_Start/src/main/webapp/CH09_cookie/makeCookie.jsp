<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="UTF-8"> -->
<title>쿠키 생성</title>
</head>
<body>
Cookie:서버에서 만들어서 클라이언트쪽에 저장되는 관리정보. 이름, 값, 유효시간, 도메인 주소, 경로등의 데이터를 저장<br>
서버안에서 만들어져 서버안에서만 쓰는 것은 세션<br>

<%
Cookie c=new Cookie("name","홍길동");
response.addCookie(c);

%>
쿠키이름::<%=c.getName() %><br>
쿠키 값::<%=c.getValue() %><br>

</body>
</html>