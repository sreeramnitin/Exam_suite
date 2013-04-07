<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.Exam" %>
<%@page import="com.data.Dao" %>
<%@page import="com.bean.Question" %>
<%@page import="java.util.LinkedList" %>
<%@page import="java.util.Iterator" %>
<%!Exam e;%>
<% e =(Exam)session.getAttribute("exam");  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Exam Suite</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<script src="scripts/datetimepicker_css.js"></script>
</head>
<body>
<%@ include file="cheader.jsp" %>
		<div id="main">
			
			<div id="disp">
				<form method="post" id=examform action="editexam2">
					<div id="test" style="width: 100%;">
					
					<%
					LinkedList<Question> lq = e.getQuestions();
					Iterator<Question> ite = lq.iterator();
					
					while(ite.hasNext())
					{
						Question q = ite.next();
					
					%>
					<div style="padding: 20px;border-bottom: 1px dashed #ccc;">
					<div id="question" ><div style="float: left;width: 2%;"><input type="radio" name="qid" value="<%=q.qid%>"/>.</div><div style="width: 98%;float: left;"><%=q.question %></div></div>
					<div style="width: 97%;display: inline-block;margin-left: 3%;">
					<div class = "option">a/ans)<%=q.options[0] %></div>
					<div class = "option">    b)<%=q.options[1] %></div>
					<div class = "option">    c)<%=q.options[2] %></div>
					<div class = "option">    d)<%=q.options[3] %></div>
					</div>
					</div>
					<%	
					
					}
					%>
						
					
					
					
					</div>
		
	
	
				
				<div class="menu1" style="background-color:#3366ff;height:70px;width:100%;">
				<div style="display:inline-block;margin:auto">
					<div class = "space1"><input class="bottem" name="btn" type="submit" value="Next"/></div>
					<div class = "space1"><input class="bottem" name="btn" type="submit" value="Edit"/></div>
					<div class = "space1"><input class="bottem" name="btn" type="submit" value="Add More"/></div>
					<div class = "space1"><input class="bottem" name="btn" type="submit" value="Delete"/></div>
					
				</div>
				</div>
				</form>
			</div>
		</div>
</body>
</html>