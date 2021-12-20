<%@page import="ch15.guestbook.service.invalidPasswordException"%>
<%@page import="ch15.guestbook.service.DeleteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 int messageId=Integer.parseInt(request.getParameter("messageId"));
 String password=request.getParameter("password");
 boolean invalidPassword=false;
 try{
	 DeleteMessageService deleteService=DeleteMessageService.getInstance();//싱글톤으로 클래스 호출
	 deleteService.deleteMessage(messageId, password);
	 
 } catch(invalidPasswordException ex){
	 invalidPassword=true;
 }
 
 %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[467]방명록 메시지 삭제함</title>
</head>
<body>
<%if(!invalidPassword){ //일치하지 않는 패스워드가 아닐경우, 즉 제대로된 패스워드 일 경우 글 삭제 %>
  
    메시지를 삭제하셨습니다.

<%}else{ %>

	입력한 암호가 올바르지 않습니다. 암호를 화인해주세요.

<%} %>
<br/>
<a href="list.jsp">목록보기</a>
</body>
</html>