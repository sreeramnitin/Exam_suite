<%@page import="com.bean.User"%>
<%!
	User u;
%>
<%		
		
		
		if(session.getAttribute("user")==null)
        {
			//session.invalidate();
			session.isNew();
			//session.setAttribute("error","");
			response.sendRedirect("");
			return;
		}
		else
		{
			u = (User)session.getAttribute("user");
		}

%>

<div id="header">
			<div style ="float:left;">Exam Suite</div>
			<div style ="float:right;"><span style="font-size:20px">Welcome <%=u.getName()%></span> <button onclick="window.location = 'logout'">Logout</button></div>
		</div>
		<input type="hidden" id="refreshed" value="no">
		<script type="text/javascript">
		onload=function(){
		var e=document.getElementById("refreshed");
		if(e.value=="no")e.value="yes";
		else{e.value="no";location.reload();}};
		</script>