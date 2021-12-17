<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>El 표기법으로 출력하기</title>
</head>
<body>
attribute name:: ${name }<br>
scope name:: ${requestScope.name }<br>
Member.id:: ${m.id }<br>
Member.name:: ${m.name } <br>
<hr>
<!-- 요청 URI(EL):: ${pageContext.getRequest().getRequestURI()} <br> -->
요청 URI(EL):: ${pageContext.request.requestURI} <br>
요청 URI(JSP):: <%=request.getRequestURI() %> <br>
파라미터 code::${param.code }   <br>
변수로 선언된 이름을 request에 담기: ${requestScope.name }<br>


변수 name에 저장한 여러번 저장하더라도 속성의 명이 다르면 다 다른 속성명으로 저장되어 각각 사용가능하다. name != m.name<br>






</body>
</html>