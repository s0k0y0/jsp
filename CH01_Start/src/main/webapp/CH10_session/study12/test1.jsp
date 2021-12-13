<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//request에 대한 새로운 세션을 생성 후 리턴
session=request.getSession(true);
String id=request.getParameter("id");
request.getSession().setAttribute("id", id);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Session 생성</h3>
새로운 세션이 생성되었습니다<br>
세션ID:<%=session.getId() %>
<a href="test2.jsp">세션내용보기</a>



링크 주소는 말그대로 링크일 뿐 링크 안에 들은 데이터를 파마리터로 보낼 수 없기 때문에 속성으로 보내야함
</body>
</html>