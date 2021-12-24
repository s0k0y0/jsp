<%@page import="jdbc.connection.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	try(Connection con = ConnectionProvider.getConnection()){
		out.println("커넥션 연결 성공함");
	}catch(SQLException ex){
		out.println("커넥션 연결 실패함"+ex.getMessage());
		application.log("커넥션 연결 실패",ex);
	}

%>

<hr>
http://localhost:8080/Ch2121_Bbs/join.do를 누르면 joinHandler로 이동하여 코드를 수행.
loginHanlder에서 로그인이 되면 index.jsp로 가서 출력하겠다?
changHanbler는 비밀번호를 바꾸기 위한 명령어가 들은 커맨더로 비밀번호를 바꿀경우 이 해들러가 작동하고 난 뒤 데이터를 담가 memberDao에게 보냄




</body>
</html>