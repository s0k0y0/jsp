<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="memberinfo" class="Member.Memberinfo"></jsp:useBean>
<!-- java 클래스에 연결하겠다 -->

<jsp:setProperty property="*" name="memberinfo"/>
<!-- 모든 속성. 즉, 변수를 가져오겠다 -->


<jsp:setProperty property="password" name="memberinfo" value="<%=memberinfo.getId() %>"/>
<!-- memberinfo의 주소값을 찾아가서 password의 변수를 가져오고 그 변수에 아이디 값을 넣겠다. set메소드 역할 -->

<table border="1">
<tr>
<td>아이디</td><td><jsp:getProperty property="id" name="memberinfo"/></td>
<td>암호</td><td><jsp:getProperty property="password" name="memberinfo"/></td>
</tr>
<tr>
<td>이름</td><td><jsp:getProperty property="name" name="memberinfo"/></td>
<td>이메일</td><td><jsp:getProperty property="email" name="memberinfo"/></td>
</tr>

</table>
<!-- 들어있는 값을 뽑아오겠다. get메소드 역할 -->













</body>
</html>