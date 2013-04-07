<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.data.Dao"  %>
    <%@page import="com.bean.*" %>
    <%@page import="java.util.LinkedList" %>
    <%@page import="java.util.Iterator" %>
    <%!Exam e;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%

	e = (Exam)session.getAttribute("exam");
	if(e==null)
	{
		response.sendError(404);
		return;
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam Suite</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script>
var min=<%=e.getDuration()%>;
var count=min * 60;
min = min-1;
var sec = 60;
var counter=setInterval(timer, 1000);
function timer()
{
  sec = sec-1;
  count=count-1;
  if (count <= 0)
  {
     clearInterval(counter);
     document.getElementById("examform").submit();
     return;
  }
  if(sec < 0)
  {
	min=min-1;
	sec = 59;
  }
 document.getElementById("timer").innerHTML=min+" min "+sec + " secs" ; 
}
</script>
</head>
<body>
<div id="header">
			<div style ="float:left;">Exam Suite</div>
			<div style ="float:right;"><span>Time Left: </span><span id="timer"></span><script>timer()</script></div>
		</div>
	<div id="main">
	<form method="post" id=examform action="val_test">
		<div id="test">
		
		<%
		LinkedList<Question> lq = e.getQuestions();
		Iterator<Question> ite = lq.iterator();
		int i = 1;
		while(ite.hasNext())
		{
			Question q = ite.next();
		
		%>
		<div style="padding: 20px;border-bottom: 1px dashed #ccc;">
		<div id="question" ><div style="float: left;width: 2%;"><%=i %>.</div><div style="width: 98%;float: left;"><%=q.question %></div></div>
		<div style="width: 97%;display: inline-block;margin-left: 3%;">
		<div class = "option"><input name="q<%=i %>" type=radio value="0"/><%=q.options[0] %></div>
		<div class = "option"><input name="q<%=i %>" type=radio value="1"/><%=q.options[1] %></div>
		<div class = "option"><input name="q<%=i %>" type=radio value="2"/><%=q.options[2] %></div>
		<div class = "option"><input name="q<%=i %>" type=radio value="3"/><%=q.options[3] %></div>
		</div>
		</div>
		<%	
		i++;
		}
		%>
			
		
		
		<div style="text-align: center;margin:20px 0px"><button type="submit" onclick="window.location = 'starttest'">Submit Exam</button></div>
		</div>
		</form>
	
	</div>
</body>
</html>