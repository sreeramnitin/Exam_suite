<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.data.Dao"  %>
    <%@page import="java.util.LinkedList" %>
    <%@page import="java.util.Iterator" %>
    <%@page import="com.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
// Popup window code
function newPopup(url) {
	popupWindow = window.open(url,'popUpWindow','height=600,width=1000,left=10,top=10,resizable=yes,scrollbars=yes,toolbar=no,menubar=no,location=no,directories=no,status=no');
}
</script>
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
					<th>Company</th>
					<th>Starts At</th>
				</tr>
				<%
					User u = (User)session.getAttribute("user");
							LinkedList<Exam> l = Dao.getRegisteredExams(u.getEmail());
							Iterator<Exam> i = l.iterator();
							while(i.hasNext())
							{
								Exam exam = i.next();
								out.print("<tr>");
								out.print("<td><a  href=\"JavaScript:newPopup('test.jsp?examid="+exam.getExamid()+"')\">"+exam.getEname()+"</a></td>");
								out.print("<td>"+exam.getComp()+"</td>");
								out.print("<td>"+exam.getSchedule()+"</td>");
								out.print("</tr>");
								
							}
				%>
				
				</table>
			</div>
	</div>
</body>
</html>