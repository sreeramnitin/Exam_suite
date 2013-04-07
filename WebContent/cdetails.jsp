<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam Suite</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<%@include file="cheader.jsp" %>
		<div id="main">
			<%@include file="cmenu.jsp"%>
			<div id = "disp">
				<div id="header" style="text-align:center">Details</div>
					<form name = "details" style="width: 73%;margin: 20px auto;line-height: 4;" method="post" action="updatecprofile">
						<div style = "float:left">
						<div style = "float:left">
						
						Description:
						</div>
						<div style = "float:right">
						
						<textarea rows="5" cols = "60" name="des"><%=c.getDes() %></textarea>
						</div>
						</div>
						<div style = "float:left;width:100%;text-align: center;"><input type="submit" value="Save"></div>
					</form>
			</div>
		</div>
</body>
</html>