<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.data.Dao" %>
<%@page import="com.bean.Exam" %>
<%@page import="java.util.LinkedList" %>
<%@page import="java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Exam Suite</title>
		<script type="text/javascript" src="mainscript.js"></script>
		<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@ include file="cheader.jsp" %>
	<form action="editordeleteexam" method="post" onsubmit="return chomeval(this)">
		<div id="main">
			<%@include file="cmenu.jsp" %>
			<div id = "disp">
				<div style="width: 100%;height: 100%;">
				<h3>Exams:</h3>
			
				<table style="width:100%;font-size:22px;text-align:center">
					<tr>
						<th></th>
						<th>Exam</th>
						<th>Starts At</th>
						<th>Duration</th>
						<th>No Of Questions in db</th>						
					</tr>
	
					<%
							Company c = (Company)session.getAttribute("company");
									LinkedList<Exam> le = Dao.getExamList(c.getName());
									
									if(le!=null)
									{
										Iterator<Exam> i = le.iterator();
										while(i.hasNext())
										{
											Exam e = i.next(); 
											out.print("<tr>");
											out.print("<td><input name=\"examid\" type=\"radio\" value=\""+e.getExamid()+"\"/></td>");
											out.print("<td><a href=\"cattendance.jsp?examid="+e.getExamid()+"&ename="+e.getEname()+"\">"+e.getEname()+"</a></td>");
											out.print("<td>"+e.getSchedule()+"</td>");
											out.print("<td>"+e.getDuration()+" min</td>");
									    	out.print("<td>"+e.getNoofque()+"</td>");				
											out.print("</tr>");
										}
									}
						%>
					</table>
				</div>
				
				<div class="menu1" style="background-color:#3366ff;height:70px;width:100%;">
				<div style="display:inline-block;margin:auto">
					<div class = "space"><a class="white" href="addexam.jsp">Add Exam</a></div>
					<div class = "space1"><input type="submit" class = "bottem" name="btn" value="Edit Exam"/></div>
					<div class= "space1"><input type="submit" class = "bottem" name="btn" value="Delete Exam"/></div>
				</div>
				</div>
				
			</div>
		</div>
		</form>
</body>
</html>