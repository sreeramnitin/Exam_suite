package com.examsuit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.state.Attendance;

/**
 * Servlet implementation class Markattd
 */
@WebServlet(name = "markattd", urlPatterns = { "/markattd" })
public class Markattd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Markattd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String examid= request.getParameter("examid");
		String ename= request.getParameter("ename");
		String temp,temp1 ;
		int i=1;
		int j= Integer.parseInt(request.getParameter("total"));
		while(i<=j)
		{
			
			temp =  request.getParameter("c"+i);
			temp1 = request.getParameter("a"+i);
			if(temp==null)
				Attendance.UnMarkAttendance(examid,temp1);
			else
				Attendance.MarkAttendance(examid, temp);
			i++;
		}
		response.sendRedirect("cattendance.jsp?examid="+examid+"&ename="+ename);
	}

}
