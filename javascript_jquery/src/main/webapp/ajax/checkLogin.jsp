<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String no=request.getParameter("no");
if(no != null){
	out.println("로그인된 상태입니다.");
}else{
	out.println("로그인이 안된 상태입니다");
}
 out.println("<br>넘어온 번호는"+no+"입니다.");
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



</body>
</html>