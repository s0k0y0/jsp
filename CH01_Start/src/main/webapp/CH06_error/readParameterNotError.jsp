<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page errorPage="error/viewErrorMessage.jsp" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
name Parameter1::<%=request.getParameter("name").toUpperCase() %>
<hr>
<%
try{
	out.println("name"+request.getParameter("name").toUpperCase());
}catch(Exception e){
	out.println("name Parameter가 올바르지 않습니다");
}

%>

<hr>

errorPage:해당 페이지가 에러가 났을 때 다른 페이지로 출력해서 보여줌<br>
#errorPage가 아닌 web.xml에서 직접 에러파일 설정 경로를 지정할 수 있음

</body>
</html>