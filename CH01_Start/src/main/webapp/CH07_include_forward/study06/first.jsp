<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<form action="second.jsp">
<fieldset>
<legend>Login</legend>
<label for="id">아이디:</label><input type="text" id="id" name="id" ><br>
<label for="pass">암 호:</label><input type="password" id="pass" name="pass" ><br>
<input type="radio" name="position" value="user">사용자
<input type="radio" name="position" value="manager" checked="checked">관리자<br>
<input type="submit" value="로그인">
</fieldset>
</form>


</body>
</html>
