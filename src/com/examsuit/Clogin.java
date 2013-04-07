package com.examsuit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Company;
import com.data.Conn;

/**
 * Servlet implementation class Clogin
 */
@WebServlet(name = "cloginserv", urlPatterns = { "/clogin" })
public class Clogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Clogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("clogin.jsp");
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
		System.out.println("clogin");
		try
		 {
			
				stmt = con.createStatement();
				 RS = stmt.executeQuery("SELECT * FROM company_users where email ='"+email+"'");		
				 
				if(RS.next() && pass.equals(RS.getString(2)))
				{
					Company c = new Company();
					c.setEmail(email);
					c.setName(RS.getString(3));
					System.out.println(pass+" "+"RS.getString(2)");
					session.setAttribute("company", c);
					session.setAttribute("error","");
					RS = stmt.executeQuery("SELECT * FROM company where name ='"+c.getName()+"'");		
					if(RS.next())
						c.setDes(RS.getString(2));
					response.sendRedirect("clogin.jsp");
					
				}
				else
				{
					session.setAttribute("error","Username and Password did not match");
					response.sendRedirect("clogin.jsp");
				}
				
		}				
	    catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				session.setAttribute("error","Username and Password did not match");
				response.sendRedirect("clogin.jsp");
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
