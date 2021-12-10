<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp::include</title>
</head>
<body>
<img src="jspInclude.jpg"><br>
<%
request.setAttribute("name1", "park");

%>
include전 name parameter값:<%=request.getParameter("name") %><hr>

<jsp:include page="body_sub.jsp">
<jsp:param value="hong" name="name"/>
</jsp:include>


<hr>
include 후 name parameter값:<%=request.getParameter("name") %><hr><br>

잠시 다른 페이지에 갔다 오는 것 include로 된 jsp문법이 있으면 해당 페이지의 jsp코드를 중지하고 include페이지로 가서 실행을 끝낸다음 다시 돌아옴<br>
name값의 hong은 include안에 있으므로 main페이지의 변수는 영향받지 않음<br>
park변수는 메인 페이지에서 선언되어 서브페이지에서 출력되는 형태임<br>



</body>
</html>