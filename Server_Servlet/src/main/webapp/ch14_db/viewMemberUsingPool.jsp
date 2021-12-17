<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록(244)</title>
</head>
<body>
	Member Table 내용::
	<br>
	<table width="100%" border="1">
		<tr>
			<td>이름</td>
			<td>아이디</td>
			<td>이메일</td>
		</tr>
		<%
		Connection conn=null;
		Statement stmt=null;
		ResultSet re=null;
		
		try {

			String jdbcDriver = "jdbc:apache:commons:dbcp:Ch14_Db";
			String query = "select * from member order by memberid";
			conn = DriverManager.getConnection(jdbcDriver);
			stmt = conn.createStatement();
			re = stmt.executeQuery(query);
			while (re.next()) {
		%>
		<tr>
			<td><%=re.getString(1)%></td>
			<td><%=re.getString(2)%></td>
			<td><%=re.getString(3)%></td>
		</tr>

		<%
		}

		} catch (Exception e) {

		} finally{
			if(re !=null){
				re.close();
			}
			if(stmt !=null){
				stmt.close();
			}
			if(conn !=null){
				conn.close();
			}
		}
		%>






	</table>




</body>
</html>