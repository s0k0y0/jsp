<%@page import="ch15.guestbook.model.Message"%>
<%@page import="ch15.guestbook.service.WriteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="message" class="ch15.guestbook.model.Message"> 
<jsp:setProperty name="message" property="*"/>
</jsp:useBean>
<!-- Message클래스를 호출해서 모든 변수들을 불러와 message라는 변수명에 넣겠다 -->

<%
WriteMessageService writeService=WriteMessageService.getInstance();
writeService.write(message);
%>
<!-- writemessageservice의 싱글톤 호출 -->
<!-- 테이블에 값을 넣는 메소드 호출 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[465]방명록 메시지 남김</title>
</head>
<body>
방명록에 메시지를 남겼습니다.<br>
<a href="list.jsp">목록보기</a>


</body>
</html>