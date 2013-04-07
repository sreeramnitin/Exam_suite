<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.LinkedList" %>
    <%@page import="java.util.Iterator" %>
    <%@page import="com.data.Dao" %>
    <%@page import="com.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<title>Exam Suite</title>
		<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@ include file="cheader.jsp" %>
<div id="main">
		<%@ include file="cmenu.jsp"%>
		<div id = "disp">
		
			
			<%
			//Company c = (Company)session.getAttribute("company");
			User u=Dao.getUserDetails(request.getParameter("email"));
			%>
			Name: <%=u.getName() %>        Last Name:<%=u.getLname() %><br/>
			Email:<%=u.getEmail() %><br/>
			College:<%=u.getCollege() %><br/>
			Address:<%=u.getAddress() %><br/>
			City:<%=u.getCity() %><br/>
			State:<%=u.getState() %><br/>
			Country:<%=u.getCountry() %><br/>
			Branch:<%=u.getBranch() %><br/>
			Course:<%=u.getEmail() %><br/>
			10 th Percentage:<%=u.getP10() %><br/>
			12 th Percentage:<%=u.getP12() %><br/>
			UG Percentage:<%=u.getUgp() %><br/>
			<br/>
		</div>
</div>
</body>
</html>