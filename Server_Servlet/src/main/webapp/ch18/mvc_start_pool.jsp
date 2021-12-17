<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Connection Pool:많은 자원을 낭비하는 Connection(연걸설정)을 사용자가 요청할때마다 연결하지 않고, <br>
미리 일정 갯수 만큼 connection을 맺어 필요한 DAO 클래스에서는 빌려 사용하고 반환하는 방법<br>
<br>
과거에는 Connection Pool기능을 구현한 클래스(DBCPInit.java)를 직접 작성해서 사용하였으나, 현재에는 <br>
Connection Pool 기능이 포함되어 있는 라이브러리(tomcat-dbcp.jar)를 사용<hr>
Pool API::Javax.sql.DataSource,JNDI(Java Naming and Directory Interface)기법<hr>
즉, 커넥션 풀을 사용하는 이유는 데이터 요청받을 때마다 드라이버로 연결하는 과정을 생략하기 위해
<img src="connectionpool1.png">
<img src="connectionpool2.png">
<img src="jndi.png"><br>

<a href="/ch18/emppool">MVC</a>

</body>
</html>