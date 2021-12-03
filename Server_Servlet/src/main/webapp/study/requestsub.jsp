<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
좋아하는 운동2:
<%=session.getAttribute("bs") %>,
<%=session.getAttribute("s") %>,
<%=session.getAttribute("bk") %><br>
성별:<%=session.getAttribute("g") %>
<br>
<br>
<br>
좋아하는 운동2:
<%=request.getParameter("baseball") %>,
<%=request.getParameter("soccer") %>,
<%=request.getParameter("basketball") %><br>
성별:<%=request.getParameter("gender") %>


</body>
</html>