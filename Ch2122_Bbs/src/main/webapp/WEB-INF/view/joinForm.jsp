<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입</title>
</head>
<body>
<form action="join.do" method="post">
<p>
아이디:<br/><input type="text" name="id" value="${param.id }">
<c:if test="${errors.id}">ID를 입력하세요.</c:if>
<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
</p>
<p>
이름:<br/><input type="text" name="name" value="${param.name }">
<c:if test="${errors.name}">이름를 입력하세요.</c:if>
</p>
<p>
암호:<br/><input type="password" name="password">
<c:if test="${errors.password}">암호를 입력하세요.</c:if>
</p>
<p>
확인:<br/><input type="password" name="confirmPassword">
<c:if test="${errors.confirmPassword}">확인를 입력하세요.</c:if>
<c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
</p>
<input type="submit" value="가입">
</form>

<br>
1.joinform에서 데이터 입력을 받는다
2.파리미터로 날라온 내용을 controllerusingfile로 넘어가서 
3.joinform에서 errors.id(아이디 에러), error.duplicate(아이디 중복),error.notMath,errors.confirmpassword도 따로 실행된다.

<hr>
-처음 시작할때, 실행은 반드시 uri을 직접적으로 쳐서 실행시켜야 함
join.do 
</body>
</html>