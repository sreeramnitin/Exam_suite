<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.data.Dao" %>
<%@page import="com.bean.Exam" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Iterator" %>
<%@page import="com.state.Attendance" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<script>
		
		var	counter=setInterval(timer, 1000);
		var sec = 5;
		function timer()
		{
			  sec=sec-1;
			  if (sec <= 0)  
			  {
			     clearInterval(counter);
			     document.getElementById("myform").submit();
			  }
			}
		
		</script>
		<script>timer();</script>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Exam Suite</title>
		<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%@ include file="cheader.jsp" %>
		<div id="main">
			<%@include file="cmenu.jsp" %>
			<div id = "disp">
				<div style="width: 100%;height: 100%;">
				<h2><%=request.getParameter("ename") %>:</h2>
				<form id="myform" action="markattd" method="post" >
				<input type="hidden" name="examid" value="<%=request.getParameter("examid")%>"/>
				<input type="hidden" name="ename" value="<%=request.getParameter("ename")%>"/>
				<table style="width:100%;font-size:22px;text-align:center">
					<tr>
						<th></th>
						<th>Student</th>						
					</tr>
	
					<%
					
									HashMap<String,Boolean> le = Attendance.getList(request.getParameter("examid"));
									int j = 0;
									if(le==null)
										out.print("No students yet");
									else
									{

										Iterator<String> i = le.keySet().iterator();
										while(i.hasNext())
										{
											j++;
											String s = i.next(); 
											out.print("<tr>");
											out.print("<td><input name=\"a"+j+"\" type=\"hidden\" value=\""+s+"\"/></td>");
											out.print("<td><input name=\"c"+j+"\" type=\"checkbox\" value=\""+s+"\" ");
											if(le.get(s))
												out.print("checked");
											out.print("/></td>");
											out.print("<td>"+s+"</td>");			
											out.print("</tr>");
										}
										
									}
									out.print("<input type =\"hidden\" name=\"total\" value=\""+j+"\"/>");
						%>
					</table>
					</form>
					<a href='closeattd?examid=<%=request.getParameter("examid")%>'>Close</a>
				</div>
				
				
			</div>
		</div>
</body>
</html>