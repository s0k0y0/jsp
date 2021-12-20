<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    <!-- page,taglib,includedirective-> 내가 만들어서 사용한다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="country" value="${'korea' }"></c:set>
<c:if test="${country !=null }">
	국가명::<c:out value="${country }"></c:out>
</c:if>

<c:choose>
<c:when test="${country=='korea' }">
<c:out value="${country }"/>의 겨울은 춥다
</c:when>


<c:when test="${country=='korea' }">
<c:out value="${country }/"/>의 겨울은 춥다
</c:when>
<c:otherwise>그 이외의 나라들의 겨울은 알 수 없다.</c:otherwise>
</c:choose>

</body>
</html>