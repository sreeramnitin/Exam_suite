<%@page import="com.bean.Company"%>
<%!
	Company c;
%>
<%		
		
		if(session.getAttribute("company")==null)
        {
			session.isNew();
			//session.setAttribute("error","");
			response.sendRedirect("");
			return;
		}
		else
		{
			c = (Company)session.getAttribute("company");
		}
%>
<div id="header">
			<div style ="float:left;">Exam Suite</div>
			<div style ="float:right;"><button onclick="window.location = 'logout'">Logout</button></div>
			<div style ="text-align:center"><%=c.getName() %></div>
</div>
<input type="hidden" id="refreshed" value="no">
		<script type="text/javascript">
		onload=function(){
		var e=document.getElementById("refreshed");
		if(e.value=="no")e.value="yes";
		else{e.value="no";location.reload();}};
</script>