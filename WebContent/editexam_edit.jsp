<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.bean.*" %>
   <%@page import="java.util.LinkedList" %>
   <%@page import="java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Exam Suite</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<script src="scripts/datetimepicker_css.js"></script>
		<%!Exam exam;
		Question q;%>
		<%exam = (Exam)session.getAttribute("exam");
		LinkedList<Question> lq = exam.getQuestions();
		Iterator<Question> i = lq.iterator();
		while(i.hasNext())
		{
			q = i.next();
			if(q.qid.equals(request.getParameter("qid")))
				break;
		}
		%>
</head>
<body>
<%@ include file="cheader.jsp" %>
		<div id="main">
			
			<div id = "disp">
			<form method="post" action = 'editquestion' style="width: 100%;height: 100%;">
				<div style="width: 100%;height: 100%;">
				<div  style="width: 100%;margin: 20px auto;float:left">
			
						<div style = "float:left;">
						<b>Question:</b>
						</div>
						<div style = "float:right width:100%">
						<textarea style = "width:100%" rows=10 name="question"><%=q.question %></textarea>
						</div>
		
					</div>
					<div  style="width: 50%;margin: 20px auto;float:left">
			
						<div style = "float:left;margin-left: 12%;">
						Option A and Answer:
						</div>
						<div style = "float:right">
						<input type ="text" name="a" value="<%=q.options[0] %>"/>
						</div>
		
					</div>
					<div  style="width: 50%;margin: 20px auto;float:left">
			
						<div style = "float:left;margin-left: 12%;">
						Option B:
						</div>
						<div style = "float:right">
						<input type ="text" name="b" value="<%=q.options[1] %>"/></div>
		
					</div>
					<div  style="width: 50%;margin: 20px auto;float:left">
			
						<div style = "float:left;margin-left: 12%;">
						Option C:
						</div>
						<div style = "float:right">
						<input type ="text" name="c" value="<%=q.options[2] %>"/></div>
		
					</div>
					<div  style="width: 50%;margin: 20px auto;float:left">
			
						<div style = "float:left;margin-left: 12%;">
						Option D:
						</div>
						<div style = "float:right">
						<input type ="text" name="d" value="<%=q.options[3] %>"/></div>
		
					</div>
				</div>
				
				<div class="menu1" style="background-color:#3366ff;height:70px;width:100%;">
				<div style="display:inline-block;margin:auto">
					<%
					
					session.setAttribute("question",q);
						out.print("<div class = \"space1\"><input class=\"bottem\" name=\"btn\" type=\"submit\" value=\"Submit\"/></div>");
					%>

				</div>
				</div>
				</form>
			</div>
		</div>
</body>
</html>