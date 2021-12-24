<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm</title>
<style type="text/css">
input{
background: pink;
}
.login{
background-color: yellow;
}
.id{
background-color: skyblue;
}



</style>
</head>
<body>
<form action="join.ide" method="post">
<!-- ide는 확장자가 없는 임시로 만든 파일프로그램. 확장프로그램이 ide나 jsp 등이 있지만 다른 파일이라도 확장프로그램명을 반드시 달리해야 톰갯의 충돌이 없어짐 -->
	<table border=1>
		<tr>
		<td colspan =2 align="center" class="login"><b>로그인</b></td>
		</tr>
		<tr>
		<td width="80px" align="center" class="id">아이디</td><td><input type="text" name="id" required autofocus></td>
		</tr>
		<tr>
		<td width="80px" align="center" class="id">암호</td><td><input type="password" name="password" required></td>
		</tr>
		<tr>
		<td colspan =2 align="center" class="id"><input type="submit" value="확인"></td>
		</tr>
	</table>
	</form>
</body>
</html>