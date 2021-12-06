<%@page import="java.util.Enumeration"%>
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
	<%=session.getAttribute("bs")%>, <!-- 서블렛에서 받아오는 속성 데이터 가져오는 속성 형식 -->
	<%=session.getAttribute("s")%>,
	<%=session.getAttribute("bk")%><br> 성별:<%=session.getAttribute("g")%>
	<br>
	<br>
	<br> 좋아하는 운동2:
	<%=request.getParameter("baseball")%>, <!-- html파일에서 직접 데이터를 가져오는 파라미터 형식 -->
	<%=request.getParameter("soccer")%>,
	<%=request.getParameter("basketball")%><br> 성별:<%=request.getParameter("gender")%>


	<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	Enumeration<String> baseball = session.getAttributeNames();
	String gender = (String) session.getAttribute("gender");

	while (baseball.hasMoreElements()) {
		String sessionName = baseball.nextElement().toString();
		String sessionValue = (String) session.getAttribute(sessionName).toString();
		out.println("Name:" + sessionName + "<br>");
		out.println("Value:" + sessionValue + "<br>");

	}
	%>
<hr>
id(JSP):<%=request.getParameter("id") %><br>
id(EL):${param.id}


</body>
</html>