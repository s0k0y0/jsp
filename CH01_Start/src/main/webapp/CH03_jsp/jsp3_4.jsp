<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 자바문법을 사용할 때는 반드시 < %으로 둘러싸여 있어야 함 -->
<%//자바를 사용하는 jsp

int sum=0;
for(int i=1; i<=10; i++){
	sum=sum+i;
}

%>

<%!//선언부. 메소드를 만드는 것. sum4

public int m(int a,int b){
	int c=a*b;
	return c;
}


%>

<%!//sum5
public int add(int a, int b){
	int c=a+b;
	return c;
}


public int subtract(int a,int b){
	int c=a-b;
	return c;
}

%>


<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
sum:<%=sum %><br>

<%
int sum2=0;
for(int i=11; i<=20; i++){
	sum2=sum2+i;
}
%>
sum2:<%=sum2 %><br>


sum3:<%=1+2+3+4+5+6+7+8+9+10 %><br>


sum4:<%=m(10,25) %><br>

sum5:<%
int var1=3;
int var2=9;

int addResult=add(var1,var2);
int sub=subtract(var1, var2);

%>

<%=var1 %>+<%=var2 %>=<%=addResult%>,<%=var1 %>-<%=var2 %>=<%=sub%>



</body>
</html>