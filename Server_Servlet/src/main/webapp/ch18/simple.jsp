<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC model2</title>
</head>
<body>
get 방식 이용시 파라미터 전송방법 3가지. 정보가 주소에 드러나는 방식<br>
1.a href를 이용하는 방법<br>
예)a href="Start.jsp?id=hong"<br>
2.form method 속성="get"전달하는 방법<br>
예)form action="Start.jsp" method="get"<br>
3.웹브라우저에 주소에 직접 Query문자열을 포함하는 url입력<br>
예)http://localhost/Server_Servlet/ch18/simple   ?type=date<hr>
<form action="simple" method="get">
<input type="text" name="type"><br>
<input type="submit" value="제출">

</form>
<a href="Start.jsp?id=hong">링크</a>

</body>
</html>