<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
//1~100: 합(jsp)=>forword=> hundredResult.jsp => EL로 결과 확인하기

<%
int num=0;

for(int i=0; i<=100; i++){
	num=num+i;
}

request.setAttribute("num", num);
RequestDispatcher d=request.getRequestDispatcher("hundredResult.jsp");
d.forward(request, response);

%>

그냥 jsp에서 쓰는 forward:: jsp:forward page="hundredResult.jsp"><br>
자바에서 쓰는 forward:: RequestDispatcher d=request.getRequestDispatcher("hundredResult.jsp");  d.forward(request, response);






</body>
</html>