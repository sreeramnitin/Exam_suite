package com.examsuit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.data.Dao;
/**
 * Servlet implementation class Register
 */
@WebServlet(name = "register", urlPatterns = { "/register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("registration.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(Dao.register(request.getParameter("email"), request.getParameter("password"),request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("college"), request.getParameter("address"), request.getParameter("city"), request.getParameter("state"), request.getParameter("country"), request.getParameter("p10"), request.getParameter("p12"), request.getParameter("course"), request.getParameter("branch"), request.getParameter("ugp")))
		{
		
			response.sendRedirect("sucess.html");
			
						
			
		}
		else
		{
			response.sendRedirect("registration.html");
		}
		}
		
	}

