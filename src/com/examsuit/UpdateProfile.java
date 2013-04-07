package com.examsuit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.data.Dao;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/updateprofile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		u.setName(request.getParameter("firstname"));
		u.setLname(request.getParameter("lastname"));
		u.setCollege(request.getParameter("college"));
		u.setAddress(request.getParameter("address"));
		u.setCity(request.getParameter("city"));
		u.setState(request.getParameter("state"));
		u.setCountry(request.getParameter("country"));
		if(Dao.updateProfile(u.getEmail(), request.getParameter("password"),request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("college"), request.getParameter("address"), request.getParameter("city"), request.getParameter("state"), request.getParameter("country")))
		{
		
			response.sendRedirect("profile.jsp");
			
						
			
		}
		else
		{
			response.sendRedirect("profile.jsp");
		}
		}
	}


