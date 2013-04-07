<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% 
    	if(session.getAttribute("company")!=null)
    		response.sendRedirect("chome.jsp");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam Suite</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
<script type="text/javascript" src="mainscript.js"></script>
</head>
<body>
<div id="header">
			Exam Suite
		</div>
		<form id="login" action="clogin" method="post" onsubmit="return LoginValidation(this)">
			<div style = "background-color:#3366ff;font-size:24px;text-align:center;margin-bottom:10px;color:white" >Company Login</div>
			<div style = "display: inline-block;width: 100%;">
				<div id="login_lables">
					Email:<br/>
					Password:
				</div>
				<div id="login_ip">
					<input id="email" type = "text" name = "email"/><br/>
					<input id="password" type = "password" name = "password">
				</div>
				
			</div>
			<%if(session.getAttribute("error")!=null)
				out.print("<div id='error'>"+session.getAttribute("error")+"</div>");
			%>
			<div id = "login_button" >
				<button type = "submit" >Login</button>
			</div>
			<div style="text-align:center">
				<a href="cregistration.html">Company Register Here</a><br/>
			</div>
		</form>
</body>
</html>