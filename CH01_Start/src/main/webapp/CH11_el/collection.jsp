<%@page import="ch11_el.Member"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jdk.swing.interop.DispatcherWrapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
//Array
<%
String[] winner =new String[3];
winner[0]="홍길동1";
winner[1]="홍길동2";
winner[2]="홍길동3";
request.setAttribute("w", winner);


//(2)arraylist 

ArrayList<String> a=new ArrayList<String>();
a.add(0, "딸기");
a.add(1, "오렌지");
a.add(2, "복숭아");
request.setAttribute("a", a);

//3.Map
//hong1=a1,hong2=a2,hong3=a3
HashMap<String,String> aa=new HashMap();
aa.put("hong1", "a1");
aa.put("hong2", "a2");
aa.put("hong3", "a3");
request.setAttribute("NAME", aa);

Member m=new Member();
m.setId("1234");
m.setName("hong");
request.setAttribute("MEM", m);


RequestDispatcher d=request.getRequestDispatcher("collectionResult.jsp");
d.forward(request, response);

%>

</body>
</html>