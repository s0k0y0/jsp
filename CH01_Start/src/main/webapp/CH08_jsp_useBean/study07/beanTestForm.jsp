<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>이름을 입력하세요</h1>
<form action="beanTestPro.jsp" method="post">
<label for="name">이름</label><input type="text" name="name" id="name">
<input type="submit" value="입력완료">
</form>

form으로 데이터들을 보냄-데이터를 받은 beanTestPro는 set으로 beanTest에 저장-값이 저장된 beanTest에서 getproperty로 호출해서 출력<br>


</body>
</html>