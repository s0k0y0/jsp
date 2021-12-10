<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
<%
Cookie[] c=request.getCookies();

if(c !=null &&c.length>0){
		for(int i=0; i<c.length; i++){
			out.println(c[i].getName()+c[i].getValue()+"<br>");
			if(c[i].getName().equals("name")){
				Cookie cc=new Cookie("name","");
				cc.setMaxAge(0);
				response.addCookie(cc);
				}
		}
}
%>
쿠키를 삭제합니다

</body>
</html>