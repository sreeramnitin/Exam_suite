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
		
		<title>Welcome to Exam Suite</title>
		<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@ include file="header.jsp" %>
<div id="main">
		<%@ include file="menu.jsp"%>
		<div id = "disp">
		
			<table style="width: 100%;text-align: center;">
			<tr>
				<th>Exam</th>
				<th>Score</th>
				<th>Min-score</th>
				<th>Result</th>
			</tr>
			<%
			User u = (User)session.getAttribute("user");
			LinkedList<Exam> le=Dao.getScore(u.getEmail());
			Iterator<Exam> ite = le.iterator();
			while(ite.hasNext())
			{
				Exam exam = ite.next();
			%>
			<tr>
				<td><%=exam.getEname() %></td>
				<td><%=exam.getScore() %>/<%=exam.getQuestions_per_exam() %></td>
				<td><%=exam.getMinscore() %>/<%=exam.getQuestions_per_exam() %></td>
				<%if(Integer.parseInt(exam.getScore())>=Integer.parseInt(exam.getMinscore())) 
					out.print("<td style=\"color:limegreen;font-weight:bold;\">Pass</td>");
				else
					out.print("<td style=\"color:red;font-weight:bold;\">Fail</td>");
				%>
			<%} %>
			</table>
		</div>
</div>
</body>
</html>