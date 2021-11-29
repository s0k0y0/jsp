<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{
margin: 0;
padding: 0;
}


</style>



</head>
<body>
<img src="cloud.jpg" id="sky" width="400" height="271"><br>
Browser inner window width:700, height 450

<script>

var cloud=document.getElementById('sky');

cloud.addEventListener("click",popdown);

function popdown() {
	window.close();
}



</script>



</body>
</html>