<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.data.Dao"  %>
    <%@page import="com.bean.*" %>
    <%!Exam e;%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
    window.onunload = refreshParent;
    function refreshParent() {
        window.opener.location.reload();
    }
</script>
<%
	Exam e = (Exam)session.getAttribute("exam");
	if(e==null)
	{
		response.sendError(404);
		return;
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
// Popup window code
function newPopup(url) {
	popupWindow = window.open(url,'popUpWindow','height=600,width=800,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=no,menubar=no,location=no,directories=no,status=no');
}
</script>
<title>Welcome to Exam Suite</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div id="header">
			<div style ="float:left;">Exam Suite</div>

		</div>
	<div id="main">
		<div id="instructions">
		<div id=header style="font-size: 26px;padding: 5px;height: initial;">Score:</div>
		<ul>
			<li>Total no of questions:<b> <%=e.getQuestions_per_exam() %></b>.</li>
			<li>Correct answers:<b> <%=e.getScore() %></b>.</li>
			<li>Result: <%
			int s = Integer.parseInt(e.getScore());
			int ms = Integer.parseInt(e.getMinscore());
			if(s>=ms)
				out.print("<b style=\"color:green\">Pass</b>");
			else
				out.print("<b style=\"color:red\">Fail</b>");
				%>.</li>
		</ul>
		<div style="text-align: center;"><button onclick="window.close()">Close</button></div>
		</div>
	</div>
</body>
</html>