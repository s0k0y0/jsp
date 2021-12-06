<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
url:http://localhost:8080/Server_servlet/simple<br>
type:data한 경우=> 날짜 출력<br>
속성으로 저장된 것은 속성으로 받아야하고 파라미터로 저장된건 파라미터로 받아와야한다

<br>
결과(sjp 속성)<%=request.getAttribute("result") %>
<br>
결과(EL 속성)${result } 
<br>
결과 (jsp 파라미터)
<%=request.getParameter("type") %>
<br>
결과 (el 파라미터)
${param.type }
<br>
</body>
</html>