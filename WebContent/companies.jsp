<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.data.Dao" %>
    <%@page import="java.util.LinkedList" %>
    <%@page import="java.util.Iterator" %>
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
			<div>
			<form name = "search_form" method="post" style="margin: auto;width: 410px;">
				<input type = "text" size="50" name = "search"/>
				<Button type = "submit">Search</button>
			</form>
			</div>
			<%
			String search = request.getParameter("search");
			LinkedList<String> l = Dao.getSearch(search);
			Iterator<String> i = l.iterator();
			while(i.hasNext())
			{
			String s = i.next();
			out.println("<div style=\"margin-top: 30px;margin-left: 40px;\"><a href=\"companies2.jsp?name="+s+"\">"+s+"</a></div>");
			}
			%>
			
		</div>
</div>
</body>
</html>