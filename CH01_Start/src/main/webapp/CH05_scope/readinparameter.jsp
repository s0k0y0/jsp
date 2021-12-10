<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초기화 파라미터를 읽어오자</title>
</head>
<body>
초기화 파라미터 목록::<br>
<hr>
::[getInitParater()]::<br>
<%
String val1= application.getInitParameter("logEnabled");
String val2= application.getInitParameter("debug Level");
out.println("logEnabled:"+val1+"<br>"+"debug Level:"+val2);


//web.xml에 있는 데이터를 가져오는 방법으로 parameter name인 param-name을 application으로 가져와 사용하도록 한다
%>

<hr>
::[getInitParameterNames()]<br>

<%


%>


<ul>

<%
Enumeration<String> initParam=application.getInitParameterNames();
while(initParam.hasMoreElements()){
	
	String name= initParam.nextElement();
	
	String value= application.getInitParameter(name);
	
	out.println("<li>"+name+":"+value+"</li>");
}


//만약 배열로 테이터를 가져와 저장하려고 한다면 getiniteparameterName()를 호출하고 넣어줌?
%>
</ul>

<ul>
<li>
<p>web.xml에 들어가 있는 데이터, 즉 변수는 공용 데이터로 스태틱같은 느낌. application처럼 어디에나 데이터 공유 가능</p>
</li>
<li> getServletContext().getInitParameter(""):jsp나 xml에 있는 변수명을 넣어 데이터를 서블릿으로 가져오는 방법</li>
<li>application이나 xml에 있는 데이터값의 변수들은 모든 사이트의 방문자가 공유할 수 있는 공유변수이다</li>
</ul>


</body>
</html>