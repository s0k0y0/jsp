<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
width: 200px;
background-color: yellow;
padding: 10px;
}
</style>
</head>
<body>
<div>
<h3>관리자로 로그인 성공</h3>
성관리 <%=request.getParameter("id")%>님 환영합니다.
</div>

</body>
</html>