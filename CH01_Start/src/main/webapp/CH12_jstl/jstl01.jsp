<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
JSTL(JSP Standard Tag Library): 태그 만드는 커스텀 태그 중에서 많이 사용되는 것을 모아서 표준으로 삼은 것<br>
내가 만든 태그들의 모음 라이브러리. 가독성으로 높이기 위해서 사용

<img src="jstl01.jpg"><br><br>
<h3>JSTL:: Core(295)</h3>
<img src="coretag table.png"><br><br>
<hr>
<%
int n1=10;
int n2=20;
%>
<c:set var="num1" value="7"></c:set>
<c:set var="num2" value="9"></c:set>
<c:set var="result1" value="${num1*num2 }"></c:set>
<c:set var="result2" value="<%=n1+n2%>"></c:set>
${num1 }와 ${num2 }의 곱은? ${result1 }<br>
<%=n1 %>와 <%=n2 %>의 곱은? ${result2 }<br>

</body>
</html>