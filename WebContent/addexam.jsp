<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Exam Suite</title>
		<link rel="stylesheet" type="text/css" href="style.css">
		<script src="scripts/datetimepicker_css.js"></script>
		<script type="text/javascript" src="mainscript.js"></script>
</head>
<body>
<%@ include file="cheader.jsp" %>
		<div id="main">
			
			<div id = "disp">
			<form method="post" action = 'addexam' style="width: 100%;height: 100%;" onsubmit="return addexamval(this)">
				<div style="width: 100%;height: 100%;">
				<div  style="width: 51%;margin: 20px auto;float:left">
			
						<div style = "float:left">
						Exam Name:
						</div>
						<div style = "float:right">
						<input type ="text" name="ename"/>
						</div>
		
					</div>
					<div  style="width: 51%;margin: 20px auto;float:left">
			
						<div style = "float:left">
						Duration in minutes:
						</div>
						<div style = "float:right">
						<input type ="text" name="duration"/>
						</div>
		
					</div>
					<div  style="width: 51%;margin: 20px auto;float:left">
			
						<div style = "float:left">
						Schedule:
						</div>
						<div style = "float:right">
						<input type ="text" name="schedule" id="dt" readonly onclick="javascript:NewCssCal ('dt','yyyyMMdd','dropdown',true,'24')"/><img src="images/cal.gif" style="cursor: pointer" onclick="javascript:NewCssCal ('dt','yyyyMMdd','dropdown',true,'24')"/>
						</div>
		
					</div>
					<div  style="width: 51%;margin: 20px auto;float:left">
			
						<div style = "float:left">
						No of questions per Exam:
						</div>
						<div style = "float:right">
						<input type ="text" name="noofquestions" /></div>
		
					</div>
					<div  style="width: 51%;margin: 20px auto;float:left">
			
						<div style = "float:left">
						minimum score:
						</div>
						<div style = "float:right">
						<input type ="text" name="minscore" /></div>
		
					</div>
				</div>
				<%if(session.getAttribute("error")!=null)
				out.print("<div id='error'>"+session.getAttribute("error")+"</div>");
				%>
				
				<div class="menu1" style="background-color:#3366ff;height:70px;width:100%;">
				<div style="display:inline-block;margin:auto">
					<div class = "space1"><button class="bottem" name="next" type="submit">Next</button></div>
					
				</div>
				</div>
				</form>
			</div>
		</div>
</body>
</html>