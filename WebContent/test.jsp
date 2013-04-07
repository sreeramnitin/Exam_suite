<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.data.Dao"  %>
    <%@page import="com.bean.*" %>
    <%@page import="com.state.Attendance" %>
    <%!Exam e;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	User u = (User)session.getAttribute("user");
	e = Dao.getMyExams(u.getEmail(), request.getParameter("examid"));
	session.setAttribute("exam",e);
	Attendance.register(e.getExamid(), u.getEmail());
	if(e==null)
	{
		response.sendError(404);
		return;
	}
	
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
// Popup window code
</script>
<title>Welcome to Exam Suite</title>
<link rel="stylesheet" type="text/css" href="style.css">
<script language="javascript" src="connection.js"></script>

</head>
<body onload="attd()">
<div id="header">
			<div style ="float:left;">Exam Suite</div>

		</div>
	<div id="main">
		<div id="instructions">
		<div id=header style="font-size: 26px;padding: 5px;height: initial;">Instructions:</div>
		<ul>
			<li>Total no of questions:<b> <%=e.getQuestions_per_exam() %></b>.</li>
			<li>Time alloted:<b> <%=e.getDuration() %></b>.</li>
		</ul>
		<div style="text-align: center;"><button id="startexam" onclick="window.location = 'starttest'" disabled>Start Exam</button></div>
		</div>
	</div>
</body>
</html>