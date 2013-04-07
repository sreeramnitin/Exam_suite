package com.examsuit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.data.Conn;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection  con = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//System.out.println("init");
	
		 
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("service");
		super.service(request,response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("");
		//this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		Connection con = Conn.getConnection(); 
		ResultSet RS;
		Statement stmt;
		try
		 {
			
				stmt = con.createStatement();
				 RS = stmt.executeQuery("SELECT * FROM participants where email ='"+email+"'");		
				
				if(RS.next() && pass.equals(RS.getString(2)))
				{
					User u = new User();
					u.setEmail(email);
					
					u.setName(RS.getString(3));
					u.setLname(RS.getString(4));
					u.setCollege(RS.getString(5));
					u.setAddress(RS.getString(6));
					u.setCity(RS.getString(7));
					u.setState(RS.getString(8));
					u.setCountry(RS.getString(9));
					u.setP10(RS.getString(10));
					u.setP12(RS.getString(11));
					u.setBranch(RS.getString(12));
					u.setCourse(RS.getString(13));
					u.setUgp(RS.getString(14));
					session.setAttribute("user",u);
					session.setAttribute("error", "");
					response.sendRedirect("home.jsp");
				}
				else
				{
					session.setAttribute("error", "Username and Password did not match");
					response.sendRedirect("");
				}
				
		}				
	    catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute("error", "Username and Password did not match");
				response.sendRedirect("");
			}
		finally
		{
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
