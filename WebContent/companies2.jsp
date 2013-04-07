<%@page import="com.bean.Exam"%>
<%@page import="com.bean.Company"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.data.Dao" %>
    <%@page import="java.util.LinkedList" %>
    <%@page import="java.util.Iterator" %>
    <%@page import="com.data.*" %>
<%!Company c;%>
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
			<div id="header" style="text-align:center"><%=request.getParameter("name")%></div>
			<div style="font-size: 30px;margin: 27px 0px;"><%
				c = Dao.getCompanyDetails(request.getParameter("name"));
				out.print(c.getDes());
			%></div>
			<table style="width:100%;font-size:20px;text-align:center">
					<tr>
						
						<th>Exam</th>
						<th>Starts At</th>
						<th>Duration</th>
						<th></th>
						
	
					<%
													LinkedList<Exam> le = c.getExams();
															
															if(le!=null)
															{
																Iterator<Exam> i = le.iterator();
																while(i.hasNext())
																{
																	Exam e = i.next(); 
																	out.print("<tr>");
																	
																	out.print("<td>"+e.getEname()+"</td>");
																	out.print("<td>"+e.getSchedule()+"</td>");
																	out.print("<td>"+e.getDuration()+" min</td>");		
																	out.print("<td><input name=\"examid\" type=\"button\" onclick=\"window.location='regexam?examid="+e.getExamid()+"'\" value=\"Register\"/></td>");
																	out.print("</tr>");
																}
															}
												%>
					</table>
				
		</div>
</div>
</body>
</html>