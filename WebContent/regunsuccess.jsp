<%@page import="com.bean.Exam"%>
<%@page import="com.bean.Company"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.data.Dao" %>
    <%@page import="java.util.LinkedList" %>
    <%@page import="java.util.Iterator" %>
    <%@page import="com.data.*" %>
<%!
	Company c;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Exam suite</title>
		
		<title>Welcome to Exam Suite</title>
		<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@ include file="header.jsp" %>
<div id="main">
		<%@ include file="menu.jsp"%>
		<div id = "disp">
			<div style="font-size: 30px;margin: 27px 0px;color:red">
			Already registered to this Exam
			</div>
			
				
		</div>
</div>
</body>
</html>