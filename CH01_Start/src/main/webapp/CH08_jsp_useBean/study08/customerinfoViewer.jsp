<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="pinfo" class="Member.personalinfo" scope="request"></jsp:useBean>
<!-- setattribute로 객체 생성 주소값을 pinfo라는 변수명으로 저장했기에 해당 jsp파일을 사용하려면 id를 주소값이 저장된 변수명으로 해야함 -->

request영역으로 부터 자바빈 객체를 가져오기<br>
이름:<jsp:getProperty property="name" name="pinfo"/><br>
성별:<jsp:getProperty property="gender" name="pinfo"/><br>
나이:<jsp:getProperty property="age" name="pinfo"/><br>



어노테이션이나 xml은 데이터를 넘기기 위한 것이 아니라, 해당 페이지로 넘어갈 수 있게끔 하는 문법
</body>
</html>