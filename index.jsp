<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> This is Welcome Page</h1>
<h4>Context Path : <%= application.getContextPath()%></h4>	 
<h4>EffectiveMajorVersion: <%= application.getEffectiveMajorVersion() %></h4>
<h4>EffectiveMinorVersion: <%= application.getEffectiveMinorVersion() %></h4>
<h4>MajorVersion: <%= application.getMajorVersion() %></h4>
<h4>MinorVersion: <%= application.getMinorVersion() %></h4>
<h4>ServerInfo: <%= application.getServerInfo() %></h4>
<h4>ServletContextName: <%= application.getServletContextName() %></h4>
<h4>ClassLoader: <%= application.getClassLoader().toString() %></h4>
<%! int counter=0; %>
<form method="post" action="looper">
	<h1>Counter is  : <%= counter++ %></h1>	
</form> 
<H1>This is Contents of ERROR Page </H1>
<p>
<%@include file="jsp/error.jsp" %>
<jsp:include page="jsp/error.jsp"></jsp:include>
</p>
</body>
</html>
