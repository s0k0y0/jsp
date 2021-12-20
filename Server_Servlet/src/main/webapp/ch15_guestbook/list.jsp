<%@page import="ch15.guestbook.service.MessageListView"%>
<%@page import="ch15.guestbook.service.GetMessageListService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[462]방명록 메시지 목록</title>
</head>
<body>
	<%
	String pageNumberStr = request.getParameter("page");
	int pageNumber = 1;
	if (pageNumberStr != null) {
		pageNumber = Integer.parseInt(pageNumberStr);
	}//page가 빈 값이 아니라면 값을 pageNumber넣고 int형식으로 변형. 글이 아무것도 없을 때만 해당 코드가 작용하고 글이 있을때는 밑의 메소드 작용

	GetMessageListService messageListService = GetMessageListService.getInstance();//getmessageservice 클래스를 싱글톤으로 불어옴
	MessageListView viewData = messageListService.getMessageList(pageNumber);//pageNumber를 list메소드를 통해 현재 페이지의 글의 인덱스들을 구함
	%>
	<c:set var="viewData" value="<%=viewData%>" />
	<!--메소드로 구한 글들의 인덱스를 변수에 넣고 그 값들을 viewData라는 변수명에 넣음 -->



	<form action="WriteMessage.jsp" method="post">
		이름:<input type="text" name="guestName"><br> 
		암호:<input type="password" name="password"><br> 
		메세지:<textarea name="message" cols="30" rows="3"></textarea> <br>
		<input type="submit" value="메세지 남기기" >
	</form>





	<hr>
	<!-- 글이 없을 경우 화면에 출력하기 위한 코드 -->
	<c:if test="${viewData.isEmpty() }">
		등록된 메세지가 없습니다.
	</c:if>
	
	<!-- 글이 있을 경우 if문과 글 내용을 보여주기 위한  반복문 -->
	<c:if test="${!viewData.isEmpty() }">
		<table>
			<c:forEach var="message" items="${viewData.messageList}">
				<tr>
					<td>메시지 번호:${message.id }<br /> 
						손님 이름:${message.guestName }<br />
						메시지:${message.message}<br /> 
						<a href="confirmDeletion.jsp?messageId=${message.id }">삭제하기</a>
					</td>
				</tr>
			</c:forEach>
	
	</table>

<!-- 하단의 전체 페이지 수를 보여주기 위한 코드 -->
<c:forEach var="pageNum" begin="1" end="${viewData.pageTotalCount }">
<a href="list.jsp?page=${pageNum }">[${pageNum}]</a>
</c:forEach>
</c:if>



</body>
</html>